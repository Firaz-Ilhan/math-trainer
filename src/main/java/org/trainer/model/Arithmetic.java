package org.trainer.model;

public interface Arithmetic {

    /**
     * Checking if the users input matches with the calculated result
     *
     * @param userInput Answer from the user for the calculation
     * @return boolean whether it was answered correctly or wrong.
     */
    boolean checkSolution(int userInput);

    /**
     * Renders the Task in the given format to be displayed
     *
     * @return String
     */
    String getRenderedTask();

    /**
     * Returning the result written in the operands index
     *
     * @return int result
     */
    int getSolution();
}