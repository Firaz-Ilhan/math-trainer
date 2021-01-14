package org.trainer.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.trainer.statistics.Statistics;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.ResourceBundle;

public class StatisticsController extends Controller implements Initializable {

    private final static Logger log = LogManager.getLogger(StatisticsController.class);

    private Statistics statistics;

    {
        try {
            statistics = new Statistics();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: stat.txt cannot be created or written to. Please check if file stat.txt exists or the permissions of file.");
            alert.showAndWait();
            log.error(e.toString());
            e.printStackTrace();
        }
    }

    @FXML
    private GridPane root;
    @FXML
    private BarChart<String, Number> barchart;

    @FXML
    private void openMenu() {
        changeScene(MAIN_MENU_FXML, root);
    }

    @FXML
    private void resetStats() {
        try {
            statistics.statReset();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: stat.txt cannot be reset. Please check if file stat.txt exists or the permissions of file.");
            alert.showAndWait();
            log.error(e.toString());
            e.printStackTrace();
        }
        changeScene(MAIN_MENU_FXML, root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int[] stats = statistics.getPercentStats();
        OptionalDouble average = Arrays.stream(stats).average();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Addition", stats[0]));
        series.getData().add(new XYChart.Data<>("Subtraction", stats[1]));
        series.getData().add(new XYChart.Data<>("Multiplication", stats[2]));
        series.getData().add(new XYChart.Data<>("Division", stats[3]));
        series.getData().add(new XYChart.Data<>("Exponent", stats[4]));
        series.getData().add(new XYChart.Data<>("Root", stats[5]));
        series.getData().add(new XYChart.Data<>("Order of Operation", stats[6]));
        series.setName("Correct answers in percent - your average is: " + (int) average.getAsDouble() + "%");
        barchart.getData().add(series);
    }
}