package org.trainer.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SettingController extends Controller implements Initializable {

    private final static Logger log = LogManager.getLogger(SettingController.class);

    @FXML
    private GridPane root;

    @FXML
    private CheckBox setAllCheckbox, additionCheckbox, subtractionCheckbox, multiplicationCheckbox, divisionCheckbox,
            orderOfOperationCheckbox, exponentCheckbox, rootCheckbox;

    @FXML
    private ToggleGroup difficulty;

    @FXML
    private Label errorLabel;

    private String getSelectedDifficulty() {
        RadioButton selectedRadioButton = (RadioButton) difficulty.getSelectedToggle();
        String toggleGroupValue = selectedRadioButton.getText();
        log.info("User selected difficulty: {}", toggleGroupValue);
        return toggleGroupValue;
    }

    private ArrayList<String> getSelectedTypes() {

        ArrayList<String> result = new ArrayList<>(7);

        if (setAllCheckbox.isSelected()) {
            result.add("addition");
            result.add("subtraction");
            result.add("multiplication");
            result.add("division");
            result.add("orderofoperation");
            result.add("exponent");
            result.add("root");
        }
        if (additionCheckbox.isSelected()) {
            result.add("addition");
        }
        if (subtractionCheckbox.isSelected()) {
            result.add("subtraction");
        }
        if (multiplicationCheckbox.isSelected()) {
            result.add("multiplication");
        }
        if (divisionCheckbox.isSelected()) {
            result.add("division");
        }
        if (orderOfOperationCheckbox.isSelected()) {
            result.add("orderofoperation");
        }
        if (exponentCheckbox.isSelected()) {
            result.add("exponent");
        }
        if (rootCheckbox.isSelected()) {
            result.add("root");
        }
        return result;
    }

    @FXML
    private void openMenu() {
        changeScene(MAIN_MENU_FXML, root);
    }

    @FXML
    private void startGame() {

        if (getSelectedTypes().isEmpty()) {
            errorLabel.setText("Please choose at least one type of calculation");
        } else {

            try {
                final FXMLLoader loader = new FXMLLoader();
                final Parent rootNode = loader.load(getClass().getResourceAsStream(GAME_FXML));
                Stage stage = (Stage) root.getScene().getWindow();
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
        }
    }

    @FXML
    private void uncheckSetAll() {
        setAllCheckbox.setSelected(false);
    }

    @FXML
    private void uncheckExercises() {
        additionCheckbox.setSelected(false);
        subtractionCheckbox.setSelected(false);
        multiplicationCheckbox.setSelected(false);
        divisionCheckbox.setSelected(false);
        orderOfOperationCheckbox.setSelected(false);
        exponentCheckbox.setSelected(false);
        rootCheckbox.setSelected(false);
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