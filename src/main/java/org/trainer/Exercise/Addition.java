package org.trainer.Exercise;

import org.trainer.Exercise.Arithmetic;

import java.util.Random;

public class Addition implements Arithmetic {

    Random rand = new Random();

    private String difficulty;

    public Addition(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public char getSign() {
        return '+';
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
        String difficultyLowerCase = difficulty.toLowerCase();
        int max = 0, min = 0, rand1, rand2, sum;

        switch (difficultyLowerCase) {
            case "easy":
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
        sum = rand1 + rand2;

        return new int[]{rand1, rand2, sum};
    }
}
