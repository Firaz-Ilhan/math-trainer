package org.trainer.GUI;

import com.sun.glass.ui.Pixels;
import com.sun.glass.ui.View;
import com.sun.javafx.stage.EmbeddedWindow;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class MainMenuController extends Application {
    private final static Logger log = LogManager.getLogger(MainMenuController.class);

    @FXML
    private Button aboutButton;
    @FXML
    private ToggleGroup difficulty;
    @FXML
    private CheckBox additionCheckbox;
    @FXML
    private CheckBox subtractionCheckbox;
    @FXML
    private CheckBox multiplicationCheckbox;
    @FXML
    private Button startGameButton;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        log.info("Starting JavaFX application");

        final String fxmlFile = "/fxml/main_menu.fxml";
        log.info("Loading FXML for main view from: {}", fxmlFile);
        final FXMLLoader loader = new FXMLLoader();
        final Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        log.info("Showing JFX scene");
        final Scene scene = new Scene(rootNode);
        //scene.getStylesheets().add("/styles/styles.css");

        stage.setTitle("Math Trainer");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void openAbout(ActionEvent actionEvent) {
        try {
            final String fxmlFile = "/fxml/about.fxml";
            Scene about = new Scene(FXMLLoader.load(getClass().getResource(fxmlFile)));
            Stage stage = (Stage) aboutButton.getScene().getWindow();
            stage.setScene(about);
            stage.show();
            log.info("Switching to: " + fxmlFile);
        } catch (IOException e1) {
            log.error(e1.toString());
            e1.printStackTrace();
        }
    }

    @FXML
    private void startGame(ActionEvent actionEvent) {
        try {
            final String fxmlFile = "/fxml/game.fxml";
            Scene game = new Scene(FXMLLoader.load(getClass().getResource(fxmlFile)));
            Stage stage = (Stage) startGameButton.getScene().getWindow();
            stage.setScene(game);
            stage.show();
            log.info("Switching to: " + fxmlFile);
        } catch (IOException e1) {
            log.error(e1.toString());
            e1.printStackTrace();
        }
    }

}