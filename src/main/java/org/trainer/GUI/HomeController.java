package org.trainer.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class HomeController {
    private final static Logger log = LogManager.getLogger(HomeController.class);

    @FXML
    public Button aboutButton;

    @FXML
    public void openAbout(ActionEvent actionEvent) {
        try {
            Scene about = new Scene(FXMLLoader.load(getClass().
                    getResource("/fxml/about.fxml")));
            Stage primaryStage = (Stage) aboutButton.getScene().getWindow();
            primaryStage.setScene(about);
            primaryStage.show();
        } catch (IOException e1) {
            log.error(e1.toString());
            e1.printStackTrace();
        }
    }
}