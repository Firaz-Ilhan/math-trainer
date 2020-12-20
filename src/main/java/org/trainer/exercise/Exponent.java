package org.trainer.exercise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Exponent extends Exercise implements Arithmetic {

    final Logger log = LogManager.getLogger(Exponent.class);
    private String difficulty;

    public Exponent(String difficulty) {
        this.difficulty = difficulty.toLowerCase();
    }

    @Override
    public String getDifficulty() {
        return difficulty;
    }

    @Override
    public int[] getTask() {
        int max = 0, min = 0, rand1;

        switch (difficulty) {
            case "beginner":
                max = 10;
                min = 1;
                break;
            case "medium":
                max = 20;
                min = 10;
                break;
            case "hard":
                max = 10;
                min = 1;
                break;
        }

        rand1 = rand.nextInt((max - min) + 1) + min;

        if (difficulty.equals("hard")) {
            log.info(rand1 + "³" + "=" + rand1 * rand1 * rand1);
            return new int[]{rand1, rand1 * rand1 * rand1}; //^3
        } else {
            log.info(rand1 + "²" + "=" + rand1 * rand1);
            return new int[]{rand1, rand1 * rand1}; //^2
        }
    }

    @Override
    public String getRenderedTask(int[] task) {
        if (difficulty.equals("hard")) {
            return task[0] + "³";
        } else {
            return task[0] + "²";
        }
    }
}
