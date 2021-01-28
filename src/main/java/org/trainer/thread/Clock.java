package org.trainer.thread;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Clock extends Thread {

    private final static Logger log = LogManager.getLogger(Clock.class);
    private int seconds;
    private int minutes;
    private int hours;
    private final SimpleStringProperty clock = new SimpleStringProperty();

    /**
     * is called every second and adds a second to the time
     */
    @Override
    public void run() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            log.info("{} minute(s) has passed", minutes);
        }
        if (minutes == 60) {
            minutes = 0;
            hours++;
            log.info("{} hour(s) has passed", hours);
        }
        Platform.runLater(() -> {
            clock.set(addingNull(minutes) + ":" + addingNull(seconds));
            if (hours != 0) {
                clock.set(addingNull(hours) + ":" + addingNull(minutes) + ":" + addingNull(seconds));
            }
        });
    }

    /**
     * adds a zero in front of the seconds or minutes if these are only single digits
     *
     * @param num gets seconds or minutes
     * @return seconds or minutes as a two-digit string
     */
    private String addingNull(int num) {
        String resultText;
        if (Integer.toString(num).length() == 1) {
            resultText = "0" + num;
        } else {
            resultText = Integer.toString(num);
        }
        return resultText;
    }

    /**
     * The GameController class gets the time
     *
     * @return text as SimpleStringProperty
     */
    public SimpleStringProperty getClock() { return clock; }
}
