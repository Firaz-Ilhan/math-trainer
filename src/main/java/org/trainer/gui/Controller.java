package org.trainer.gui;

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
    final String Statistics_FXML = "/fxml/statistics.fxml";
    final String SETTING_FXML = "/fxml/setting.fxml";

    /**
     * Provides a method to change to a Scene without passing parameters
     *
     * @param fxmlFile the view you would like to switch to
     * @param root     the root pane of the current scene
     */
    public void changeScene(String fxmlFile, Pane root) {
        try {
            final FXMLLoader loader = new FXMLLoader();
            final Parent root2 = loader.load(getClass().getResource(fxmlFile));
            final Scene scene = new Scene(root2, root.getWidth(), root.getHeight());
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
