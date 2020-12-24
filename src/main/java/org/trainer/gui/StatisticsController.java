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

    @FXML
    private GridPane root;
    @FXML
    private BarChart<String, Number> barchart;

    XYChart.Series<String, Number> series = new XYChart.Series<>();
    Statistics statistics = new Statistics();

    @FXML
    private void openMenu() {
        changeScene(MAIN_MENU_FXML, root);
    }

    @FXML
    private void resetStatistic() {
       statistics.statReset();
        series.getData().clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int[] stats;

        stats = statistics.getPercentStats(true);

        series.getData().add(new XYChart.Data<>("Addition", stats[0]));
        series.getData().add(new XYChart.Data<>("Subtraktion", stats[1]));
        series.getData().add(new XYChart.Data<>("Multiplikation", stats[2]));
        series.getData().add(new XYChart.Data<>("Division", stats[3]));
        series.getData().add(new XYChart.Data<>("Exponent", stats[4]));
        series.getData().add(new XYChart.Data<>("Root", stats[5]));
        series.getData().add(new XYChart.Data<>("Order of Operation", stats[6]));
        series.setName("Correct answers in percent");
        barchart.getData().add(series);
    }
}
