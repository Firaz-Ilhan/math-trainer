package org.trainer.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutController extends Controller implements Initializable {

    @FXML
    public GridPane root;
    @FXML
    private TextArea aboutTextArea;

    @FXML
    public void openHome(ActionEvent actionEvent) {
        changeScene(MAIN_MENU_FXML, root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String osName = System.getProperty("os.name");
        String osArch = System.getProperty("os.arch");
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        aboutTextArea.setText("Operating System: " + osName + ' ' + osArch + '\n'
                + "Java runtime version: " + javaVersion + '\n'
                + "JavaFX version: " + javafxVersion + '\n' + '\n'
                + "Math Trainer: 1.0" + '\n' + '\n');
    }
}
