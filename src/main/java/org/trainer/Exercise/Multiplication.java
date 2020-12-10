package org.trainer.Exercise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Multiplication extends Exercise implements Arithmetic {

    final Logger log = LogManager.getLogger(Multiplication.class);
    private String difficulty;

    public Multiplication(String difficulty) {
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
        int max = 0, min = 0, rand1, rand2, product;

        switch (difficulty) {
            case "beginner":
                max = 10;
                min = 1;
                break;
            case "medium":
                max = 12;
                min = 6;
                break;
            case "hard":
                max = 15;
                min = 10;
                break;

        }

        rand1 = rand.nextInt((max - min) + 1) + min;
        rand2 = rand.nextInt((max - min) + 1) + min;
        product = rand1 * rand2;

        log.info(rand1 + " * " + rand2 + " = " + product);
        return new int[]{rand1, rand2, product};
    }

    @Override
    public String getRenderedTask(int[] task) {
        return task[0] + "*" + task[1];
    }
}