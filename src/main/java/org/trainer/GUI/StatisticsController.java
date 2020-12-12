package org.trainer.GUI;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.trainer.Exercise.Addition;
import org.trainer.Exercise.Arithmetic;
import org.trainer.GUI.AboutController;
import org.trainer.Statistics.Statistics;
import org.trainer.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StatisticsController extends Statistics implements Initializable {

    int[] stats;

    final Logger log = LogManager.getLogger(StatisticsController.class);

    final static String austria = "Austria";
    final static String brazil = "Brazil";
    final static String france = "France";
    final static String italy = "Italy";
    final static String usa = "USA";

    @FXML
    public GridPane root;
    @FXML
    private TextArea aboutTextArea;
    private Object FxChartUtil;
    @FXML
    private BarChart<String, Number> barchart;

    @FXML
    public void openStatistics(ActionEvent actionEvent) {
        try {
            final String fxmlFile = "/fxml/main_menu.fxml";
            Parent root2 = FXMLLoader.load(getClass().getResource(fxmlFile));
            Scene scene = new Scene(root2, root.getWidth(), root.getHeight());
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            log.info("Switching to: " + fxmlFile);
        } catch (IOException e1) {
            log.warn(e1.toString());
            e1.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Statistics statistics = new Statistics();
        stats = statistics.getPercentStats(true);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Addition", stats[0]));
        series.getData().add(new XYChart.Data<>("Subtraktion", stats[1]));
        series.getData().add(new XYChart.Data<>("Multiplikation", stats[2]));
        series.getData().add(new XYChart.Data<>("Division", stats[3]));
        series.getData().add(new XYChart.Data<>("Exponent", stats[4]));
        series.getData().add(new XYChart.Data<>("Root", stats[5]));
        series.getData().add(new XYChart.Data<>("Order of Operation", stats[6]));
        barchart.getData().add(series);
    }
}
