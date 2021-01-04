package org.trainer.model;

import java.util.Random;

public class Task {

    final Random RAND = new Random();

    final String BEGINNER = "beginner";
    final String MEDIUM = "medium";
    final String HARD = "hard";

    /**
     * Checks if the user input matches the calculated solution.
     *
     * @param task  int array with task numbers and solution.
     * @param input the users input.
     * @return true if solved successfully.
     */
    public boolean checkSolution(int[] task, int input) {
        if (task == null || task.length == 0) {
            return false;
        } else {
            return input == task[task.length - 1];
        }
    }

    /**
     * Returns the solution provided in the last array index.
     *
     * @param task int array with task numbers and solution.
     * @return solution int.
     */
    public int getSolution(int[] task) {
        return task[task.length - 1];
    }
}
