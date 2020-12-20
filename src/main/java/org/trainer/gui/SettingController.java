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

import java.io.IOException;

public class SettingController extends Controller {

    private final static Logger log = LogManager.getLogger(SettingController.class);

    @FXML
    private GridPane root;

    @FXML
    private CheckBox additionCheckbox, subtractionCheckbox, multiplicationCheckbox, divisionCheckbox,
            orderOfOperationCheckbox, exponentCheckbox, rootCheckbox;

    @FXML
    private RadioButton beginnerRadioButton, mediumRadioButton, hardRadioButton;

    @FXML
    private ToggleGroup difficulty;

    private String getSelectedDifficulty() {
        RadioButton selectedRadioButton = (RadioButton) difficulty.getSelectedToggle();
        String toggleGroupValue = selectedRadioButton.getText();
        log.info("User selected difficulty: " + toggleGroupValue);
        return toggleGroupValue;
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

            stage.setScene(scene);
            stage.show();
            log.info("Switching to: " + GAME_FXML + "and passing parameters");
        } catch (IOException e1) {
            log.error(e1.toString());
            e1.printStackTrace();
        }
        return stage;
    }
}
