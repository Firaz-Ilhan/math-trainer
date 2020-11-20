package org.trainer.GuiPackage.GuiHelper;

import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberField extends TextField {

  private static Logger log = LogManager.getLogger(NumberField.class);

  private int value = 0;

  public NumberField() {

    setText("0");
    textProperty().addListener((event, oldValue, newValue) -> {
      switch (newValue.trim()) {
        case "":
        case "-":
          return;
      }

      try {
        value = Integer.parseInt(newValue);
      } catch (final NumberFormatException e) {
        log.warn("Rejecting illegal age input: «" + newValue + "»");
        setText(oldValue);
      }
    });
  }

  public int getValue() {
    return value;
  }
}