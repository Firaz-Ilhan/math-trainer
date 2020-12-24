package org.trainer.gui;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class ResultController extends Controller {

    @FXML
    private GridPane root;
    @FXML
    private TextArea resultField;

    public void initUserResult(String userResult) {
        resultField.setText(userResult);
    }

    @FXML
    private void openMenu() {
        changeScene(MAIN_MENU_FXML, root);
    }

    @FXML
    public void openStatistics() {
        changeScene(Statistics_FXML, root);
    }
}
