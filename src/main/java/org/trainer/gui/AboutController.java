package org.trainer.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
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
    private void openMenu() {
        changeScene(MAIN_MENU_FXML, root);
    }

    @FXML
    private void openGithubLink() {
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Firaz-Ilhan/math-trainer").toURI());
            log.info("User opened github repository");
        } catch (URISyntaxException | IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("URL Error");
            alert.setHeaderText(null);
            alert.setContentText("Could not open link with your default web browser. Try to copy the link in your web browser");
            alert.showAndWait();
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

        root.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                openMenu();
            }
        });
    }
}
