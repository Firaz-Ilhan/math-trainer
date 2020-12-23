package org.trainer.gui;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class MainMenuController extends Controller {

    @FXML
    private VBox root;

    @FXML
    private void openAbout() {
        changeScene(ABOUT_FXML, root);
    }

    @FXML
    private void openStatistics() {
        changeScene(Statistics_FXML, root);
    }

    @FXML
    private void newGame() {
        changeScene(SETTING_FXML, root);
    }

}