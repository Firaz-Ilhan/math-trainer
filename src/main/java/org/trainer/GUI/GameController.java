package org.trainer.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.trainer.Exercise.Arithmetic;
import org.trainer.Exercise.Factory;
import org.trainer.exceptions.IllegalFactoryArgument;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    public Button stopGameButton;
    @FXML
    public Label taskLabel;
    @FXML
    public Button answerButton;
    @FXML
    public TextField answerField;
    @FXML
    public Label gameModeratorAnswer;

    private final static Logger log = LogManager.getLogger(GameController.class);

    private final Factory f1 = new Factory();
    private Arithmetic taskType;
    private int[] task;

    public void stopGame(ActionEvent actionEvent) {
        try {
            final String fxmlFile = "/fxml/main_menu.fxml";
            Scene main_menu = new Scene(FXMLLoader.load(getClass().
                    getResource(fxmlFile)));
            Stage primaryStage = (Stage) stopGameButton.getScene().getWindow();
            primaryStage.setScene(main_menu);
            primaryStage.show();
            log.info("Switching to: " + fxmlFile);
        } catch (IOException e1) {
            log.error(e1.toString());
            e1.printStackTrace();
        }
    }

    private void typeLoader() {
        try {
            String randomType = f1.getRandomType(true, true, true, true, true);
            taskType = f1.getArithmetic(randomType, "beginner");

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
    public void enterAnswer(ActionEvent actionEvent) {
        int input = Integer.parseInt(answerField.getText());

        if (taskType.checkSolution(task, input)) {
            gameModeratorAnswer.setText(input + " is correct");
        } else {
            gameModeratorAnswer.setText(input + " is NOT correct. Correct answer " + taskType.getSolution(task));
        }
        typeLoader();
        displayTask();
        answerField.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayTask();
    }
}
