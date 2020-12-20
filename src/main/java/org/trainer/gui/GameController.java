package org.trainer.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import org.trainer.exceptions.IllegalFactoryArgument;
import org.trainer.exercise.Arithmetic;
import org.trainer.exercise.Factory;
import org.trainer.statistics.Statistics;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController extends Controller implements Initializable {

    @FXML
    private GridPane root;
    @FXML
    private Label taskLabel;
    @FXML
    public TextField answerField;
    @FXML
    private Label gameModeratorAnswer;

    private final Factory f1 = new Factory();
    private final Statistics statCollector = new Statistics();
    private Arithmetic taskType;
    private String randomType;
    private int[] task;
    private String difficulty;

    public void initDifficulty(String selectedDifficulty) {
        this.difficulty = selectedDifficulty;
    }

    @FXML
    private void stopGame() {
        changeScene(MAIN_MENU_FXML, root);
    }

    private void typeLoader() {
        try {
            randomType = f1.getRandomType(true, true, true, true, true, true, true);
            taskType = f1.getArithmetic(randomType, difficulty);

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
    private void enterAnswer() {

        if (answerField.getText().matches("-?[0-9]{0,10}") && !answerField.getText().isEmpty()) {
            int numericInput = Integer.parseInt(answerField.getText());

            if (taskType.checkSolution(task, numericInput)) {
                gameModeratorAnswer.setText(numericInput + " is correct");
            } else {
                gameModeratorAnswer.setText(numericInput + " is NOT correct. Correct answer " + taskType.getSolution(task));
            }

            statCollector.collector(randomType, taskType.checkSolution(task, numericInput));
            statCollector.statSaver();
            typeLoader();
            displayTask();
            answerField.clear();
        } else {
            gameModeratorAnswer.setText("Enter a number into the input field");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> answerField.requestFocus());
        Platform.runLater(() -> displayTask());

        answerField.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                enterAnswer();
            }

            if (event.getCode() == KeyCode.ESCAPE) {
                stopGame();
            }
        });
    }
}