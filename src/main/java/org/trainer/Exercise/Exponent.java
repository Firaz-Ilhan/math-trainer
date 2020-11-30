package org.trainer.Exercise;

public class Exponent extends Exercise implements Arithmetic {

    private String difficulty;

    public Exponent(String difficulty) {
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
            case "hard":
                max = 10;
                min = 1;
                break;

            case "medium":
                max = 100;
                min = 11;
                break;

        }
        rand1 = rand.nextInt((max - min) + 1) + min;

        if (difficulty.equals("hard")) {
            return new int[]{rand1, rand1 * rand1 * rand1}; //^3
        } else {
            return new int[]{rand1, rand1 * rand1}; //^2
        }

    }

    @Override
    public String getRenderedTask(int[] task) {
        if (difficulty.equals("hard")) {
            return task[0] + "^" + 3;
        } else {
            return task[0] + "^" + 2;
        }
    }

    @Override
    public boolean checkSolution(int[] task, int input) {
        if (task == null || task.length == 0) {
            return false;
        } else {
            return input == task[1];
        }
    }
}

