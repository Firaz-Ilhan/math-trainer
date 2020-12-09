package org.trainer.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class MainMenuController {
    private final static Logger log = LogManager.getLogger(MainMenuController.class);

    @FXML
    public Button aboutButton;
    @FXML
    public ToggleGroup difficulty;
    @FXML
    public CheckBox additionCheckbox;
    @FXML
    public CheckBox subtractionCheckbox;
    @FXML
    public CheckBox multiplicationCheckbox;
    @FXML
    public Button startGameButton;

    //private RadioButton selectedDifficulty = (RadioButton) difficulty.getSelectedToggle();

    @FXML
    public void openAbout(ActionEvent actionEvent) {
        try {
            final String fxmlFile = "/fxml/about.fxml";
            Scene about = new Scene(FXMLLoader.load(getClass().
                    getResource(fxmlFile)));
            Stage primaryStage = (Stage) aboutButton.getScene().getWindow();
            primaryStage.setScene(about);
            primaryStage.show();
            log.info("Switching to: " + fxmlFile);
        } catch (IOException e1) {
            log.error(e1.toString());
            e1.printStackTrace();
        }
    }

    @FXML
    public void startGame(ActionEvent actionEvent) {
        try {
            final String fxmlFile = "/fxml/game.fxml";
            Scene game = new Scene(FXMLLoader.load(getClass().
                    getResource(fxmlFile)));
            Stage primaryStage = (Stage) startGameButton.getScene().getWindow();
            primaryStage.setScene(game);
            primaryStage.show();
            log.info("Switching to: " + fxmlFile);
        } catch (IOException e1) {
            log.error(e1.toString());
            e1.printStackTrace();
        }
    }

}