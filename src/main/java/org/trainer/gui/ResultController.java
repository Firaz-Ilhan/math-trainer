package org.trainer.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import org.trainer.streams.WrongAnswer;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultController extends Controller implements Initializable {

    @FXML
    private GridPane root;
    @FXML
    private TextArea resultField;
    @FXML
    private Button textAreaToggle;

    private String userStats;
    private boolean wrongAnswerEnabled;
    private final WrongAnswer wrongAnswer = new WrongAnswer();

    public void initUserResult(String userResult) {
        resultField.setText(userResult);
        userStats = userResult;
    }

    @FXML
    private void showWrongAnswers() {
        if (wrongAnswerEnabled) {
            resultField.setStyle("-fx-font: 30 System;");
            resultField.setText(userStats);
            textAreaToggle.setText("Wrong Answers");
            wrongAnswerEnabled = false;
        } else {
            resultField.setStyle("-fx-font: 25 System;");
            wrongAnswer.sortWrongAnswers();
            resultField.setText("Addition\n" + wrongAnswer.listToString(wrongAnswer.listAddi) + "\n"
                    + "Subtraction\n" + wrongAnswer.listToString(wrongAnswer.listSubt) + "\n"
                    + "Multiplication\n" + wrongAnswer.listToString(wrongAnswer.listMulti) + "\n"
                    + "Division\n" + wrongAnswer.listToString(wrongAnswer.listDivi) + "\n"
                    + "Exponent\n" + wrongAnswer.listToString(wrongAnswer.listExpo2)
                    + wrongAnswer.listToString(wrongAnswer.listExpo3) + "\n"
                    + "Root\n" + wrongAnswer.listToString(wrongAnswer.listRoot2)
                    + wrongAnswer.listToString(wrongAnswer.listRoot3) + "\n"
                    + "Order Of Operation\n" + wrongAnswer.listToString(wrongAnswer.listOrder) + "\n");
            textAreaToggle.setText("Result");
            wrongAnswerEnabled = true;
        }
    }

    @FXML
    private void openMenu() {
        changeScene(MAIN_MENU_FXML, root);
    }

    @FXML
    public void openStatistics() {
        changeScene(Statistics_FXML, root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                openMenu();
            }
        });
    }
}
