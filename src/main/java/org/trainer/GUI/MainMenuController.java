package org.trainer.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

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
    private void newGame(ActionEvent actionEvent) {
        changeScene(SETTING_FXML, root);
    }

}