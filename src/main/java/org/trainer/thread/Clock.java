package org.trainer.thread;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;

import java.util.TimerTask;

public class Clock extends TimerTask implements Runnable {

    private int seconds;
    private int minutes;
    private int hours;
    private SimpleStringProperty text = new SimpleStringProperty();

    @Override
    public void run() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }
        if (minutes == 60) {
            minutes = 0;
            hours++;
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
