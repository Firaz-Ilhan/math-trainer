package org.trainer.exercise;

public interface Arithmetic {

    String getDifficulty();

    int[] getTask();

    String getRenderedTask(int[] task);

    boolean checkSolution(int[] task, int input);

    int getSolution(int[] task);
}
