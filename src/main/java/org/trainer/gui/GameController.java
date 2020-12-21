package org.trainer.gui;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
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
import java.util.Timer;
import java.util.TimerTask;

public class GameController extends Controller implements Initializable {

    @FXML
    private GridPane root;
    @FXML
    private Label taskLabel;
    @FXML
    public TextField answerField;
    @FXML
    private Label gameModeratorAnswer;
    @FXML
    private Label setTimer;

    private final Factory f1 = new Factory();
    private final Statistics statCollector = new Statistics();
    private Arithmetic taskType;
    private String randomType;
    private int[] task;
    private String difficulty;
    private SimpleStringProperty text = new SimpleStringProperty("undifined");
    private int seconds;
    private int minutes;
    private int hours;

    public void initDifficulty(String selectedDifficulty) {
        this.difficulty = selectedDifficulty;
    }

    @FXML
    private void stopGame() {
        statCollector.statSaver();
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
        Clock myTask = new Clock();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(myTask, 0 , 1000);
        setTimer.textProperty().bind(text);
    }

    private class Clock extends TimerTask implements Runnable {

        @Override
        public void run() {
            seconds++;
            if (seconds == 60) {
                seconds = 0;
                minutes++;
            }
            if (minutes == 60) {
                minutes = 0;
                hours++;
            }
            Platform.runLater(() -> {
                text.set(addingNull(minutes) + ":" + addingNull(seconds));
                if (hours != 0) {
                    text.set(addingNull(hours) + ":" + addingNull(minutes) + ":" + addingNull(seconds));
                }
            });
        }
    }
    private String addingNull(int num) {
        String resultText;
        if (Integer.toString(num).length() == 1) {
            resultText =  "0" + num;
        } else {
            resultText = Integer.toString(num);
        }
        return resultText;
    }
}