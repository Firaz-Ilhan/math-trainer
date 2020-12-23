package org.trainer.model;

public interface Arithmetic {

    String getDifficulty();

    /**
     * Creates the task array which holds all number information.
     * @return int array with numbers and solution of the task.
     */
    int[] getTask();

    /**
     * Creates a String out of the task array which the user will see.
     * @param task int array with numbers and solution of the task.
     * @return String which is a fully generated task as seen for the user.
     */
    String getRenderedTask(int[] task);

    /**
     * Checks if the user input matches the calculated solution.
     * @param task int array with numbers and solution of the task.
     * @param input user input.
     * @return boolean about successful solving.
     */
    boolean checkSolution(int[] task, int input);

    /**
     * Takes the solution provided by the task array and returns it.
     * @param task int array with numbers and solution of the task.
     * @return int of the solution.
     */
    int getSolution(int[] task);
}
