package org.trainer.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FxmlGuiDriver extends Application {

	private static final Logger log = LogManager.getLogger(FxmlGuiDriver.class);

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        log.info("Starting JavaFX application");

        final String fxmlFile = "/fxml/home.fxml";
        log.debug("Loading FXML for main view from: {}", fxmlFile);
        final FXMLLoader loader = new FXMLLoader();
        final Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        log.debug("Showing JFX scene");
        final Scene scene = new Scene(rootNode);
        //scene.getStylesheets().add("/styles/styles.css");

        stage.setTitle("Math Trainer");
        stage.setScene(scene);
        stage.show();
    }
}
