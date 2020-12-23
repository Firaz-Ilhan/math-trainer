package org.trainer.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;
import org.trainer.statistics.Statistics;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticsController extends Controller implements Initializable {

    int[] stats;

    @FXML
    private GridPane root;
    @FXML
    private BarChart<String, Number> barchart;

    @FXML
    private void openMenu() {
        changeScene(MAIN_MENU_FXML, root);
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
