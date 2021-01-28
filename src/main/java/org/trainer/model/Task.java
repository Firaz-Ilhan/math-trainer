package org.trainer.model;

import java.util.Random;

public class Task implements Arithmetic {

    int[] operands;
    String difficulty;
    String renderedTask;

    final String BEGINNER = "beginner";
    final String MEDIUM = "medium";
    final String HARD = "hard";
    final Random RAND = new Random();

    public String getDifficulty() {
        return difficulty;
    }

    public String getRenderedTask() {
        return renderedTask;
    }

    public int getSolution() {
        return operands[operands.length - 1];
    }

    public boolean checkSolution(int userInput) {
        return userInput == operands[operands.length - 1];
    }
}