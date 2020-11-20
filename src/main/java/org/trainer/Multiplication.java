package org.trainer;

import java.util.Random;

public class Multiplication implements Arithmetic {

    Random rand = new Random();

    private String difficulty;

    public Multiplication(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public char getSign() {
        return '*';
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
        int max = 0, min = 0, rand1, rand2, product;

        switch (difficultyLowerCase) {
            case "easy":
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

        return new int[]{rand1, rand2, product};
    }
}