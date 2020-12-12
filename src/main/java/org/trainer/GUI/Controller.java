package org.trainer.GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Controller {

    private final static Logger log = LogManager.getLogger(Controller.class);

    final String MAIN_MENU_FXML = "/fxml/main_menu.fxml";
    final String ABOUT_FXML = "/fxml/about.fxml";
    final String GAME_FXML = "/fxml/game.fxml";

    public void changeScene(String fxmlFile, Pane root) {
        try {
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
