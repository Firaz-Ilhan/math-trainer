package org.trainer.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.trainer.exceptions.IllegalFactoryArgument;
import org.trainer.model.Arithmetic;
import org.trainer.model.Factory;
import org.trainer.model.Helper;
import org.trainer.statistics.Statistics;
import org.trainer.streams.WrongAnswer;
import org.trainer.thread.Clock;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameController extends Controller implements Initializable {

    private final static Logger log = LogManager.getLogger(GameController.class);

    @FXML
    private Label difficultyLabel;
    @FXML
    private GridPane root;
    @FXML
    private Label taskLabel;
    @FXML
    private TextField answerField;
    @FXML
    private Label gameModerator;
    @FXML
    private Label setTimer;

    private final Factory factory = new Factory();
    private final WrongAnswer wrongAnswer = new WrongAnswer();
    private Statistics statCollector;
    private Arithmetic taskType;
    private ArrayList<String> ArithmeticType;
    private String randomType;
    private String difficulty;
    private ScheduledExecutorService executorService;

    {
        try {
            statCollector = new Statistics();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: stat.txt cannot be created or written to. Please check if file stat.txt exists or the permissions of file.");
            alert.showAndWait();
            log.error(e.toString());
            e.printStackTrace();
        }
    }

    /**
     * initialize difficulty from {@link SettingController}
     *
     * @param selectedDifficulty selected by user in {@link SettingController}
     */
    public void initDifficulty(String selectedDifficulty) {
        difficulty = selectedDifficulty.toLowerCase();
    }

    /**
     * initialize arithmetic types from {@link SettingController}
     *
     * @param arithmeticType selected by user in {@link SettingController}
     */
    public void initTypes(ArrayList<String> arithmeticType) {
        ArithmeticType = arithmeticType;
    }

    /**
     * stops the game and the {@link Clock} thread
     * and pass statistics related information to {@link ResultController}
     */
    @FXML
    private void stopGame() {
        final String userResult = statCollector.getStats(false); //lifetime is a feature that may be implemented in the future
        try {
            statCollector.statSaver();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: stat.txt cannot be written to. Please check if file stat.txt exists or the permissions of file.");
            alert.showAndWait();
            log.error(e.toString());
            e.printStackTrace();
        }

        try {
            final FXMLLoader loader = new FXMLLoader();
            final Parent rootNode = loader.load(getClass().getResourceAsStream(RESULT_FXML));
            final Stage stage = (Stage) root.getScene().getWindow();
            final Scene scene = new Scene(rootNode, root.getWidth(), root.getHeight());

            final ResultController resultController = loader.getController();
            resultController.initUserResult(userResult);

            stage.setScene(scene);
            stage.show();
            log.info("Switching to: " + RESULT_FXML + " and passing parameters");
        } catch (IOException e1) {
            log.error(e1.toString());
            e1.printStackTrace();
        }
        executorService.shutdown();
    }

    /**
     * loads an arithmetic type. See implementation {@link Factory}.
     */
    private void typeLoader() {
        try {
            randomType = factory.getRandomType(ArithmeticType);
            taskType = factory.getArithmetic(randomType, difficulty);
        } catch (IllegalFactoryArgument e1) {
            e1.printStackTrace();
        }
    }

    private void displayTask() {
        typeLoader();
        taskLabel.setText(taskType.getRenderedTask());
    }

    @FXML
    private void skipTask() {
        int solution = taskType.getSolution();
        gameModerator.setText("Correct answer was: " + solution);
        log.info("User skipped task");
        statCollector.collector(randomType, false);
        displayTask();
        answerField.clear();
    }

    @FXML
    private void enterAnswer() {
        if (Helper.checkInputPattern(answerField.getText())) {
            int numericInput = Integer.parseInt(answerField.getText());

            log.info("User entered: {}", numericInput);

            if (taskType.checkSolution(numericInput)) {
                gameModerator.setText(numericInput + " is correct");
            } else {
                gameModerator.setText(numericInput + " is NOT correct. Correct answer: " + taskType.getSolution());
                wrongAnswer.addWrongAnswer(taskType.getRenderedTask(), Integer.toString(taskType.getSolution()), answerField.getText());
            }
            statCollector.collector(randomType, taskType.checkSolution(numericInput));
            displayTask();
            answerField.clear();
        } else {
            gameModerator.setText("Enter a number into the input field");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> answerField.requestFocus()); //sets focus on answerField
        Platform.runLater(this::displayTask); //displays first task
        Platform.runLater(() -> difficultyLabel.setText(difficulty)); //displays the selected task

        //while focus is on answerField
        answerField.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                enterAnswer();
            }
        });

        root.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                stopGame();
            }
        });

        executorService = Executors.newScheduledThreadPool(1, r -> {
            Thread thread = Executors.defaultThreadFactory().newThread(r);
            thread.setDaemon(true);
            return thread;
        });

        final Clock clock = new Clock();
        clock.setDaemon(true);
        clock.start();
        executorService.scheduleAtFixedRate(clock, 1L, 1L, TimeUnit.SECONDS); //initialDelay is needed because of gui load time
        setTimer.textProperty().bind(clock.getClock());
    }
}