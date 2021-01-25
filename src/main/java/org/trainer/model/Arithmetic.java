package org.trainer.model;

public interface Arithmetic {

    int[] getOperands();

    boolean checkSolution(int userInput);

    String getRenderedTask();

    int getSolution();
}