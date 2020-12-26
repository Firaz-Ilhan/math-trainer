package org.trainer.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import org.trainer.statistics.Statistics;
import org.trainer.thread.Clock;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;

public class GameController extends Controller implements Initializable {

    private final static Logger log = LogManager.getLogger(GameController.class);

    @FXML
    private Label difficultyLabel;
    @FXML
    private GridPane root;
    @FXML
    private Label taskLabel;
    @FXML
    public TextField answerField;
    @FXML
    private Label gameModerator;
    @FXML
    private Label setTimer;

    private final Factory factory = new Factory();
    private final Statistics statCollector = new Statistics();
    private Arithmetic taskType;
    private ArrayList<String> ArithmeticType;
    private String randomType;
    private int[] task;
    private String difficulty;

    public void initDifficulty(String selectedDifficulty) {
        this.difficulty = selectedDifficulty;
    }

    public void initTypes(ArrayList<String> ArithmeticType) {
        this.ArithmeticType = ArithmeticType;
    }

    @FXML
    private void stopGame() {
        String userResult = statCollector.getStats(false);
        statCollector.statSaver();

        try {
            final FXMLLoader loader = new FXMLLoader();
            final Parent rootNode = loader.load(getClass().getResourceAsStream(RESULT_FXML));
            Stage stage = (Stage) root.getScene().getWindow();
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
    }

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
        task = taskType.getTask();
        taskLabel.setText(taskType.getRenderedTask(task));
    }

    @FXML
    private void skipTask() {
        int solution = taskType.getSolution(task);
        gameModerator.setText("Correct answer was: " + solution);
        typeLoader();
        displayTask();
    }

    @FXML
    private void enterAnswer() {
        if (answerField.getText().matches("-?[0-9]{0,10}") && !answerField.getText().isEmpty()) {
            int numericInput = Integer.parseInt(answerField.getText());

            if (taskType.checkSolution(task, numericInput)) {
                gameModerator.setText(numericInput + " is correct");
            } else {
                gameModerator.setText(numericInput + " is NOT correct. Correct answer " + taskType.getSolution(task));
            }

            statCollector.collector(randomType, taskType.checkSolution(task, numericInput));
            typeLoader();
            displayTask();
            answerField.clear();
        } else {
            gameModerator.setText("Enter a number into the input field");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> answerField.requestFocus());
        Platform.runLater(() -> displayTask());
        Platform.runLater(() -> difficultyLabel.setText(difficulty));

        answerField.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                enterAnswer();
            }

            if (event.getCode() == KeyCode.ESCAPE) {
                stopGame();
            }
        });
        Clock clock = new Clock();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(clock, 0, 1000);
        setTimer.textProperty().bind(clock.updateText());
    }
}