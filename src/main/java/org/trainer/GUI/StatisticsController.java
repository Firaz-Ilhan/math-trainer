package org.trainer.GUI;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.trainer.Statistics.Statistics;
import java.net.URL;
import java.util.ResourceBundle;

public class StatisticsController extends Statistics implements Initializable {

    int[] stats;

    final Logger log = LogManager.getLogger(StatisticsController.class);

    @FXML
    public GridPane root;
    @FXML
    private BarChart<String, Number> barchart;

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
