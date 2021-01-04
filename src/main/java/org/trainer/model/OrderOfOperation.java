package org.trainer.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderOfOperation extends Task implements Arithmetic {

    private static final Logger log = LogManager.getLogger(OrderOfOperation.class);
    private final String difficulty;

    /**
     * Constructor.
     *
     * @param difficulty setting the difficulty for {@link #getTask()}.
     */
    public OrderOfOperation(String difficulty) {
        this.difficulty = difficulty.toLowerCase();
    }

    @Override
    public String getDifficulty() {
        return difficulty;
    }

    @Override
    public int[] getTask() {
        int max = 0, min = 0, rand1, rand2, rand3, sum;

        switch (difficulty) {
            case BEGINNER:
                max = 10;
                min = 1;
                break;
            case MEDIUM:
                max = 15;
                min = 11;
                break;
            case HARD:
                max = 20;
                min = 16;
                break;
        }

        rand1 = RAND.nextInt((max - min) + 1) + min;
        rand2 = RAND.nextInt((max - min) + 1) + min;
        rand3 = RAND.nextInt((max - min) + 1) + min;
        sum = rand1 + rand2 * rand3;

        log.info("{}+{}*{}={}", rand1, rand2, rand3, sum);
        return new int[]{rand1, rand2, rand3, sum};
    }

    @Override
    public String getRenderedTask(int[] task) {
        return task[0] + "+" + task[1] + "*" + task[2];
    }
}
