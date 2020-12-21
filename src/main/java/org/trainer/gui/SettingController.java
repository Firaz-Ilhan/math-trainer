package org.trainer.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.trainer.exercise.ArithmeticType;

import java.io.IOException;
import java.util.ArrayList;

public class SettingController extends Controller {

    private final static Logger log = LogManager.getLogger(SettingController.class);

    @FXML
    private GridPane root;

    @FXML
    private CheckBox additionCheckbox, subtractionCheckbox, multiplicationCheckbox, divisionCheckbox,
            orderOfOperationCheckbox, exponentCheckbox, rootCheckbox;

    @FXML
    private ToggleGroup difficulty;

    private String getSelectedDifficulty() {
        RadioButton selectedRadioButton = (RadioButton) difficulty.getSelectedToggle();
        String toggleGroupValue = selectedRadioButton.getText();
        log.info("User selected difficulty: " + toggleGroupValue);
        return toggleGroupValue;
    }

    private ArrayList<String> getSelectedTypes() {

        ArrayList<String> result = new ArrayList<>(7);

        if (additionCheckbox.isSelected()) {
            result.add(ArithmeticType.ADDITION.toString());
        }
        if (subtractionCheckbox.isSelected()) {
            result.add(ArithmeticType.SUBTRACTION.toString());
        }
        if (multiplicationCheckbox.isSelected()) {
            result.add(ArithmeticType.MULTIPLICATION.toString());
        }
        if (divisionCheckbox.isSelected()) {
            result.add(ArithmeticType.DIVISION.toString());
        }
        if (orderOfOperationCheckbox.isSelected()) {
            result.add(ArithmeticType.ORDER_OF_OPERATION.toString());
        }
        if (exponentCheckbox.isSelected()) {
            result.add(ArithmeticType.EXPONENT.toString());
        }
        if (rootCheckbox.isSelected()) {
            result.add(ArithmeticType.ROOT.toString());
        }
        return result;
    }

    @FXML
    private void openMenu(ActionEvent actionEvent) {
        changeScene(MAIN_MENU_FXML, root);
    }

    @FXML
    private Stage startGame() {
        Stage stage = new Stage();

        try {
            final FXMLLoader loader = new FXMLLoader();
            final Parent rootNode = loader.load(getClass().getResourceAsStream(GAME_FXML));
            stage = (Stage) root.getScene().getWindow();
            final Scene scene = new Scene(rootNode, root.getWidth(), root.getHeight());

            final GameController gameController = loader.getController();
            gameController.initDifficulty(getSelectedDifficulty());
            gameController.initTypes(getSelectedTypes());

            stage.setScene(scene);
            stage.show();
            log.info("Switching to: " + GAME_FXML + " and passing parameters");
        } catch (IOException e1) {
            log.error(e1.toString());
            e1.printStackTrace();
        }
        return stage;
    }
}
