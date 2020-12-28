package org.trainer.thread;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.TimerTask;

public class Clock extends TimerTask {

    private final static Logger log = LogManager.getLogger(Clock.class);

    private int seconds;
    private int minutes;
    private int hours;
    private final SimpleStringProperty text = new SimpleStringProperty();

    @Override
    public void run() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            log.info(minutes + " minute(s) has passed");
        }
        if (minutes == 60) {
            minutes = 0;
            hours++;
            log.info(hours + " hour(s) has passed");
        }
        Platform.runLater(() -> {
            text.set(addingNull(minutes) + ":" + addingNull(seconds));
            if (hours != 0) {
                text.set(addingNull(hours) + ":" + addingNull(minutes) + ":" + addingNull(seconds));
            }
        });
    }

    private String addingNull(int num) {
        String resultText;
        if (Integer.toString(num).length() == 1) {
            resultText = "0" + num;
        } else {
            resultText = Integer.toString(num);
        }
        return resultText;
    }

    public SimpleStringProperty updateText() {
        return text;
    }
}
