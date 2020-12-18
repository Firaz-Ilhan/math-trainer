package org.trainer.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class SettingController extends Controller {

    @FXML
    private GridPane root;

    @FXML
    private CheckBox additionCheckbox, subtractionCheckbox, multiplicationCheckbox, divisionCheckbox,
            orderOfOperationCheckbox, exponentCheckbox, rootCheckbox;

    @FXML
    private RadioButton beginnerRadioButton, mediumRadioButton, hardRadioButton;

    @FXML
    private ToggleGroup difficulty;

    public void openMenu(ActionEvent actionEvent) {
        changeScene(MAIN_MENU_FXML, root);
    }

    public void startGame(ActionEvent actionEvent) {
        changeScene(GAME_FXML, root);
    }
}
