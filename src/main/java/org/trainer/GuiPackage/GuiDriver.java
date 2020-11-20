package org.trainer.GuiPackage;

import org.trainer.GuiPackage.GuiHelper.Dialog;
import org.trainer.GuiPackage.GuiHelper.NumberField;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GuiDriver extends Application {

  private static Logger log = LogManager.getLogger(GuiDriver.class);

  private final static int
      colIndex_0 = 0,
      colIndex_1 = 1;

  private final Button resetBtn = new Button(Conf.get("resetButton.text"));
  private final TextField nameField = new TextField();
  private final NumberField ageField = new NumberField();

  public static void main(String[] args) {
    launch(args);
  }

  public GuiDriver() {

    resetBtn.setDisable(true);

    nameField.textProperty().addListener(event -> {
      log.info("Name value '" + nameField.getText() + "' has been entered");
      resetBtn.setDisable(false);
    });

    ageField.textProperty().addListener(event -> {
      log.info("Age value '" + ageField.getText() + "' has been entered");
      resetBtn.setDisable(false);
    });

    resetBtn.setOnAction(event -> {
      nameField.setText("");
      ageField.setText("");
      resetBtn.setDisable(true);
      Dialog.showInfo(Conf.get("infoFieldReset"));
      log.info("re-setting name field");
    });
  }

  @Override
  public void start(final Stage primaryStage) {

    primaryStage.setTitle("Sample GUI");

    final GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));

    int currentRowIndex = 0;
    final Text scenetitle = new Text("Simple GUI example");
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    grid.add(scenetitle, colIndex_0, currentRowIndex, 2, 1);

    currentRowIndex++;
    grid.add(new Label("Your name:"), colIndex_0, currentRowIndex);
    grid.add(nameField, colIndex_1, currentRowIndex);

    currentRowIndex++;
    grid.add(new Label("Your age:"), colIndex_0, currentRowIndex);
    grid.add(ageField, colIndex_1, currentRowIndex);

    currentRowIndex++;
    grid.add(resetBtn, colIndex_0, currentRowIndex);

    final Scene scene = new Scene(grid, 300, 250);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  @Override
  public void stop() throws Exception {
    super.stop();
    log.info("Terminating application");
  }
}