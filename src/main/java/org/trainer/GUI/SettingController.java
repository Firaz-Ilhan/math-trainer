package org.trainer.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class SettingController extends Controller {

    @FXML
    private GridPane root;

    public void openMenu(ActionEvent actionEvent) {
        changeScene(MAIN_MENU_FXML, root);
    }

    public void startGame(ActionEvent actionEvent) {
        changeScene(GAME_FXML, root);
    }
}
