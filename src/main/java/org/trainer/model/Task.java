package org.trainer.model;

import java.util.Random;

public class Task {

    final Random rand = new Random();

    /**
     * Checks if the user input matches the calculated solution.
     *
     * @param task  int array with task numbers and solution.
     * @param input the users input.
     * @return boolean if solved successfully.
     */
    public boolean checkSolution(int[] task, int input) {
        if (task == null || task.length == 0) {
            return false;
        } else {
            return input == task[task.length - 1];
        }
    }

    /**
     * Returns the solution provided in the last array slot.
     *
     * @param task int array with task numbers and solution.
     * @return solution int.
     */
    public int getSolution(int[] task) {
        return task[task.length - 1];
    }
}
