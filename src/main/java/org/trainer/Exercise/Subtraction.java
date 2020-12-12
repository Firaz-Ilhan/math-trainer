package org.trainer.Exercise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Subtraction extends Exercise implements Arithmetic {

    final Logger log = LogManager.getLogger(Subtraction.class);
    private String difficulty;

    public Subtraction(String difficulty) {
        this.difficulty = difficulty.toLowerCase();
    }

    @Override
    public String getDifficulty() {
        return difficulty;
    }

    @Override
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public int[] getTask() {
        int max = 0, min = 0, rand1, rand2, diff;

        switch (difficulty) {
            case "beginner":
                max = 20;
                min = 1;
                break;
            case "medium":
                max = 30;
                min = 20;
                break;
            case "hard":
                max = 40;
                min = 30;
                break;
        }

        rand1 = rand.nextInt((max - min) + 1) + min;
        rand2 = rand.nextInt((max - min) + 1) + min;
        diff = rand1 - rand2;

        log.info(rand1 + "-" + rand2 + "=" + diff);
        return new int[]{rand1, rand2, diff};
    }

    @Override
    public String getRenderedTask(int[] task) {
        return task[0] + "-" + task[1];
    }
}
