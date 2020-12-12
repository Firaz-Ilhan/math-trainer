package org.trainer.GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class MainMenuController extends Application {
    private final static Logger log = LogManager.getLogger(MainMenuController.class);

    @FXML
    private VBox root;
    @FXML
    private Button aboutButton;
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
            Parent root2 = FXMLLoader.load(getClass().getResource(fxmlFile));
            Scene scene = new Scene(root2, root.getWidth(), root.getHeight());
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
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
            Parent root2 = FXMLLoader.load(getClass().getResource(fxmlFile));
            Scene scene = new Scene(root2, root.getWidth(), root.getHeight());
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            log.info("Switching to: " + fxmlFile);
        } catch (IOException e1) {
            log.error(e1.toString());
            e1.printStackTrace();
        }
    }

}