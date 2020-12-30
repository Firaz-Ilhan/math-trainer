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
import org.trainer.streams.WrongAnswer;
import org.trainer.thread.Clock;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.regex.Pattern;

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
    private final Statistics statCollector = new Statistics();
    private Arithmetic taskType;
    private ArrayList<String> ArithmeticType;
    private String randomType;
    private int[] task;
    private String difficulty;
    private final Timer timer = new Timer(true);
    private final Pattern pattern = Pattern.compile("-?[0-9]{0,10}");

    public void initDifficulty(String selectedDifficulty) {
        difficulty = selectedDifficulty;
    }

    public void initTypes(ArrayList<String> arithmeticType) {
        ArithmeticType = arithmeticType;
    }

    @FXML
    private void stopGame() {
        final String userResult = statCollector.getStats(false);
        statCollector.statSaver();

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
        timer.cancel();
        timer.purge();
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
        log.info("User skipped task");
        statCollector.collector(randomType, false);
        typeLoader();
        displayTask();
        answerField.clear();
    }

    @FXML
    private void enterAnswer() {
        if (pattern.matcher(answerField.getText()).matches() && !answerField.getText().isEmpty()) {
            int numericInput = Integer.parseInt(answerField.getText());

            log.info("User entered: {}", numericInput);

            if (taskType.checkSolution(task, numericInput)) {
                gameModerator.setText(numericInput + " is correct");
            } else {
                gameModerator.setText(numericInput + " is NOT correct. Correct answer " + taskType.getSolution(task));
                WrongAnswer wrongAnswer = new WrongAnswer();
                wrongAnswer.addWrongAnswer(taskType.getRenderedTask(task), Integer.toString(taskType.getSolution(task)), answerField.getText());
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
        timer.scheduleAtFixedRate(clock, 0, 1000);
        setTimer.textProperty().bind(clock.updateText());
    }
}