package org.trainer.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Addition extends Task implements Arithmetic {

    private static final Logger log = LogManager.getLogger(Addition.class);
    private final String difficulty;

    /**
     * Constructor.
     *
     * @param difficulty setting the difficulty for {@link #getTask()}.
     */
    public Addition(String difficulty) {
        this.difficulty = difficulty.toLowerCase();
    }

    @Override
    public String getDifficulty() {
        return difficulty;
    }

    @Override
    public int[] getTask() {
        int max = 0, min = 0, rand1, rand2, sum;

        switch (difficulty) {
            case "beginner":
                max = 30;
                min = 1;
                break;
            case "medium":
                max = 40;
                min = 20;
                break;
            case "hard":
                max = 50;
                min = 30;
                break;
        }

        rand1 = rand.nextInt((max - min) + 1) + min;
        rand2 = rand.nextInt((max - min) + 1) + min;
        sum = rand1 + rand2;

        log.info("{}+{}={}", rand1, rand2, sum);
        return new int[]{rand1, rand2, sum};
    }


    @Override
    public String getRenderedTask(int[] task) {
        return task[0] + "+" + task[1];
    }
}
