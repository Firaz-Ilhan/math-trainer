package org.trainer.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderOfOperation extends Task {

    private static final Logger log = LogManager.getLogger(OrderOfOperation.class);

    /**
     * Constructor calling the methods to set all parameters to work with
     *
     * @param difficulty set by the User
     */
    public OrderOfOperation(String difficulty) {
        this.difficulty = difficulty;
        this.operands = new int[4];
        this.operands = createOperationArray();
        this.renderedTask = renderTask();
    }

    /**
     * Creates int[] with operands and result
     *
     * @return operands.clone int[]
     */
    private int[] createOperationArray() {
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
        operands[0] = rand1;
        operands[1] = rand2;
        operands[2] = rand3;
        operands[operands.length - 1] = rand1 + rand2 * rand3;

        log.info("{}+{}*{}={}", operands[0], operands[1], operands[2], operands[3]);

        return operands.clone();
    }

    /**
     * Renders the int[] into the desired task format: X + Y * Z
     *
     * @return String to be displayed
     */
    private String renderTask() {
        return operands[0] + "+" + operands[1] + "*" + operands[2];
    }
}
