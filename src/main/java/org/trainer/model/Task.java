package org.trainer.model;

import java.util.Random;

public class Task {

    protected int[] operands;
    protected String difficulty = "beginner";
    protected String renderedTask = "";

    protected final String BEGINNER = "beginner";
    protected final String MEDIUM = "medium";
    protected final String HARD = "hard";
    protected final Random RAND = new Random();

    public Task() {
    }

    public int[] getOperands() {
        return operands;
    }

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