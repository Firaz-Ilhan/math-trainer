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

    /**
     * Getter for Difficulty
     *
     * @return String
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Getter for the rendered Task
     *
     * @return String
     */
    public String getRenderedTask() {
        return renderedTask;
    }

    /**
     * Getter for solution which is in the operands Array
     *
     * @return int
     */
    public int getSolution() {
        return operands[operands.length - 1];
    }

    /**
     * Checking if the userInput matches the calculated result
     *
     * @return boolean
     */
    public boolean checkSolution(int userInput) {
        return userInput == operands[operands.length - 1];
    }
}