package org.trainer.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController extends Controller {

    @FXML
    private VBox root;

    @FXML
    private void openAbout(ActionEvent actionEvent) {
        changeScene(ABOUT_FXML, root);
    }

    @FXML
    private void openStatistics(ActionEvent actionEvent) {
       changeScene(Statistics_FXML, root);
    }

    @FXML
    private void startGame(ActionEvent actionEvent) {
        changeScene(GAME_FXML, root);
    }

}