package org.trainer.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Multiplication extends Task {

    private static final Logger log = LogManager.getLogger(Multiplication.class);

    /**
     * Constructor calling the methods to set all parameters to work with
     *
     * @param difficulty set by the User
     */
    public Multiplication(String difficulty) {
        this.difficulty = difficulty;
        this.operands = new int[3];
        this.operands = createOperationArray();
        this.renderedTask = renderTask();
    }

    /**
     * Creates int[] with operands and result
     *
     * @return operands.clone int[]
     */
    private int[] createOperationArray() {
        int max = 0, min = 0, rand1, rand2;

        switch (difficulty) {
            case BEGINNER:
                max = 9;
                min = 1;
                break;
            case MEDIUM:
                max = 12;
                min = 6;
                break;
            case HARD:
                max = 15;
                min = 10;
                break;

        }

        rand1 = RAND.nextInt((max - min) + 1) + min;
        rand2 = RAND.nextInt((max - min) + 1) + min;
        operands[0] = rand1;
        operands[1] = rand2;
        operands[2] = rand1 * rand2;

        log.info("{}*{}={}", operands[0], operands[1], operands[2]);

        return operands.clone();
    }

    /**
     * Renders the int[] into the desired task format: X * Y
     *
     * @return String to be displayed
     */
    private String renderTask() {
        return operands[0] + "*" + operands[1];
    }
}
