package org.trainer;

public class Addition implements CalculationService {

    private String difficulty;
    private int amountOfTasks;

    public Addition(String difficulty, int amountOfTasks) {
        this.difficulty = difficulty;
        this.amountOfTasks = amountOfTasks;
    }

    @Override
    public char getSign() {
        return '+';
    }

    @Override
    public int getAmountOfTasks() {
        return amountOfTasks;
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
    public void setAmountOfTasks(int amountOfTask) {
        this.amountOfTasks = amountOfTask;
    }

    @Override
    public int[] getTask() {
        String difficultyLowerCase = difficulty.toLowerCase();
        int max = 0, min = 0, rand1, rand2, sum;

        switch (difficultyLowerCase) {
            case "easy":
                max = 20;
                min = 1;
                break;
            case "medium":
                max = 21;
                min = 30;
                break;
            case "hard":
                max = 30;
                min = 40;
                break;

        }

        rand1 = rand.nextInt((max - min) + 1) + min;
        rand2 = rand.nextInt((max - min) + 1) + min;
        sum = rand1 + rand2;

        return new int[]{rand1, rand2, sum};
    }
}
