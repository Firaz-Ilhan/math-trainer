package org.trainer.model2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Root extends Task implements Interface {

    private static final Logger log = LogManager.getLogger(Root.class);

    public Root(String difficulty) {
        this.difficulty = difficulty;
        this.operands = new int[2];
        this.operands = createTask();
        this.renderedTask = renderTask();
    }


    public int[] createTask() {
        int max = 0, min = 0, rand1;

        switch (difficulty) {
            case BEGINNER:
                max = 8;
                min = 1;
                break;
            case MEDIUM:
                max = 20;
                min = 8;
                break;
            case HARD:
                max = 15;
                min = 3;
                break;
        }

        rand1 = RAND.nextInt((max - min) + 1) + min;
        operands[1] = rand1;

        if (difficulty.equals("hard")) {
            operands[0] = rand1 * rand1 * rand1;
            log.info("³√{}={}", operands[0], operands[1]);
        } else {
            operands[0] = rand1 * rand1;
            log.info("²√{}={}", operands[0], operands[1]);
        }

        return operands.clone();
    }

    public String renderTask() {
        if (difficulty.equals("hard")) {
            return "³√" + operands[0];
        } else {
            return "²√" + operands[0];
        }
    }
}
