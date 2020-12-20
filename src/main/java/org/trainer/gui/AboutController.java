package org.trainer.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutController extends Controller implements Initializable {

    private static final Logger log = LogManager.getLogger(AboutController.class);

    @FXML
    private GridPane root;
    @FXML
    private TextArea aboutTextArea;

    @FXML
    private void openHome(ActionEvent actionEvent) {
        changeScene(MAIN_MENU_FXML, root);
    }

    @FXML
    private void openGithubLink(ActionEvent actionEvent) {
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Firaz-Ilhan/math-trainer").toURI());
            log.info("User opened github repository");
        } catch (URISyntaxException | IOException e) {
            log.error(e.toString());
            e.printStackTrace();
        }
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
