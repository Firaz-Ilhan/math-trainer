package org.trainer.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Initializable {

    private final static Logger log = LogManager.getLogger(AboutController.class);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String osName = System.getProperty("os.name");
        String osArch = System.getProperty("os.arch");
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        aboutTextArea.setText("Operating System: " + osName + ' ' + osArch + '\n'
                + "Java runtime version: " + javaVersion + '\n'
                + "JavaFX version: " + javafxVersion + '\n' + '\n'
                + "Math Trainer: 1.0" + '\n' + '\n'
                + "Developers:" + '\n'
                + "Firaz Ilhan" + '\n'
                + "Jens Schlegel" + '\n'
                + "Maximillian Dolbaum" + '\n' + '\n'
                + "https://github.com/Firaz-Ilhan/math-trainer");
    }

    @FXML
    public TextArea aboutTextArea;
    public Button aboutToHomeButton;

    @FXML
    public void openHome(ActionEvent actionEvent) throws IOException {
        try {
            Scene home = new Scene(FXMLLoader.load(getClass().
                    getResource("/fxml/home.fxml")));
            Stage primaryStage = (Stage) aboutToHomeButton.getScene().getWindow();
            primaryStage.setScene(home);
            primaryStage.show();
        } catch (IOException e1) {
            log.warn(e1.toString());
            e1.printStackTrace();
        }
    }
}
