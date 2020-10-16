package org.trainer.GuiHelper;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * See http://code.makery.ch/blog/javafx-dialogs-official
 * for further explanations.
 */
public class Dialog {


  /**
   * Show a modal info box
   *
   * @param msg A message to be displayed
   */
  public static void showInfo(final String msg) {
    final Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Info");
    alert.setContentText(msg);
    alert.showAndWait();
  }

  /**
   * Showing an error box and terminating without any further error processing
   *
   * @param msg      An informative message
   * @param ex       The exception to be interpreted by an expert
   * @param exitCode The exit code to be used by e.g. the calling process.
   */
  public static void showExceptionAndExit(final String msg, final Exception ex, int exitCode) {

    final Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Unrecoverable error");
    alert.setHeaderText("Application will be terminated!");
    alert.setContentText(msg);


    // Create expandable Exception.

    if (null != ex) {
      final StringWriter sw = new StringWriter();
      final PrintWriter pw = new PrintWriter(sw);
      ex.printStackTrace(pw);
      final String exceptionText = sw.toString();

      final Label label = new Label("You may copy and forward this exception stacktrace to an expert:");

      final TextArea textArea = new TextArea(exceptionText);
      textArea.setEditable(false);
      textArea.setWrapText(true);

      textArea.setMaxWidth(Double.MAX_VALUE);
      textArea.setMaxHeight(Double.MAX_VALUE);
      GridPane.setVgrow(textArea, Priority.ALWAYS);
      GridPane.setHgrow(textArea, Priority.ALWAYS);

      final GridPane expContent = new GridPane();
      expContent.setMaxWidth(Double.MAX_VALUE);
      expContent.add(label, 0, 0);
      expContent.add(textArea, 0, 1);

      // Set expandable Exception into the dialog pane.
      alert.getDialogPane().setExpandableContent(expContent);
    }
    alert.showAndWait();
    System.exit(exitCode);
  }
}