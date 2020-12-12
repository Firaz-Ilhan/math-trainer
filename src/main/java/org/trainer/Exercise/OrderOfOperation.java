package org.trainer.Exercise;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderOfOperation extends Exercise implements Arithmetic {

    final Logger log = LogManager.getLogger(OrderOfOperation.class);
    private String difficulty;

    public OrderOfOperation(String difficulty) {
        this.difficulty = difficulty.toLowerCase();
    }

    @Override
    public String getDifficulty() {
        return difficulty;
    }

    @Override
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty.toLowerCase();
    }

    @Override
    public int[] getTask() {
        int max = 0, min = 0, rand1, rand2, rand3, sum;

        switch (difficulty) {
            case "beginner":
                max = 10;
                min = 1;
                break;
            case "medium":
                max = 15;
                min = 11;
                break;
            case "hard":
                max = 20;
                min = 16;
                break;
        }

        rand1 = rand.nextInt((max - min) + 1) + min;
        rand2 = rand.nextInt((max - min) + 1) + min;
        rand3 = rand.nextInt((max - min) + 1) + min;
        sum = rand1 + rand2 * rand3;

        log.info(rand1 + "+" + rand2 + "*" + rand3 + "=" + sum);
        return new int[]{rand1, rand2, rand3, sum};
    }

    @Override
    public String getRenderedTask(int[] task) {
        return task[0] + "+" + task[1] + "*" + task[2];
    }
}
