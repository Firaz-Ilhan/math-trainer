package org.trainer.Exercise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Root extends Exercise implements Arithmetic {

    final Logger log = LogManager.getLogger(Root.class);
    private String difficulty;

    public Root(String difficulty) {
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
        int max = 0, min = 0, rand1;

        switch (difficulty) {
            case "beginner":
                max = 8;
                min = 1;
                break;
            case "medium":
                max = 20;
                min = 8;
                break;
            case "hard":
                max = 15;
                min = 3;
                break;
        }

        rand1 = rand.nextInt((max - min) + 1) + min;

        if (difficulty.equals("hard")) {
            log.info("³√" + rand1 * rand1 * rand1 + "=" + rand1);
            return new int[]{rand1 * rand1 * rand1, rand1}; //^3
        } else {
            log.info("²√" + rand1 * rand1 + "=" + rand1);
            return new int[]{rand1 * rand1, rand1}; //^2
        }
    }

    @Override
    public String getRenderedTask(int[] task) {
        if (difficulty.equals("hard")) {
            return  "³√" + task[0];
        } else {
            return  "²√" + task[0];
        }
    }
}