package org.trainer.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Exponent extends Task implements Arithmetic {

    private static final Logger log = LogManager.getLogger(Subtraction.class);

    public Exponent(String difficulty) {
        this.difficulty = difficulty;
        this.operands = new int[2];
        this.operands = createOperationArray();
        this.renderedTask = renderTask();
    }

    private int[] createOperationArray() {
        int max = 0, min = 0, rand1;

        switch (difficulty) {
            case BEGINNER: //fallthrough since it has the same value as HARD
            case HARD:
                max = 10;
                min = 1;
                break;
            case MEDIUM:
                max = 20;
                min = 10;
                break;
        }

        rand1 = RAND.nextInt((max - min) + 1) + min;
        operands[0] = rand1;

        if (difficulty.equals("hard")) {
            operands[1] = rand1 * rand1 * rand1;
            log.info("{}³={}", operands[0], operands[1]);
        } else {
            operands[1] = rand1 * rand1;
            log.info("{}²={}", operands[0], operands[1]);
        }

        return operands.clone();
    }

    private String renderTask() {
        if (difficulty.equals("hard")) {
            return operands[0] + "³";
        } else {
            return operands[0] + "²";
        }
    }
}
