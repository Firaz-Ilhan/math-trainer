package org.trainer.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Subtraction extends Task implements Arithmetic {

    private static final Logger log = LogManager.getLogger(Subtraction.class);
    private final String difficulty;

    /**
     * Constructor.
     *
     * @param difficulty setting the difficulty for {@link #getTask()}.
     */
    public Subtraction(String difficulty) {
        this.difficulty = difficulty.toLowerCase();
    }

    @Override
    public String getDifficulty() {
        return difficulty;
    }

    @Override
    public int[] getTask() {
        int max = 0, min = 0, rand1, rand2, diff;

        switch (difficulty) {
            case BEGINNER:
                max = 20;
                min = 1;
                break;
            case MEDIUM:
                max = 30;
                min = 20;
                break;
            case HARD:
                max = 40;
                min = 30;
                break;
        }

        rand1 = RAND.nextInt((max - min) + 1) + min;
        rand2 = RAND.nextInt((max - min) + 1) + min;
        diff = rand1 - rand2;

        log.info("{}-{}={}", rand1, rand2, diff);
        return new int[]{rand1, rand2, diff};
    }

    @Override
    public String getRenderedTask(int[] task) {
        return task[0] + "-" + task[1];
    }
}
