package org.trainer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A simple controller providing a callback method {@link #sayHello()}
 *
 */
public class HelloController {
    private final static Logger log = LogManager.getLogger(HelloController.class);

    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private Label helloLabel;

    /**
     * deriving a greeting message from firstName and lastName
     */
    @FXML public void sayHello() {

        final String firstName = firstNameField.getText();
        final String lastName = lastNameField.getText();

        final StringBuilder builder = new StringBuilder();

        if (0 < firstName.trim().length()) {
            builder.append(firstName);
            if (0 < lastName.trim().length()) {
                builder.append(' ').append(lastName);
            }
        } else if (0 < lastName.trim().length()) {
            builder.append(lastName);
        }

        if (0 < builder.length()) {
            final String name = builder.toString();
            log.debug("Saying hello to " + name);
            helloLabel.setText("Hello " + name);
        } else {
            log.debug("Neither first name nor last name was set, saying hello to anonymous person");
            helloLabel.setText("Hello mysterious person");
        }
    }
}