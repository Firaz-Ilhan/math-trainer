package org.trainer.Exercise;

public interface Arithmetic {

    String getDifficulty();

    void setDifficulty(String difficulty);

    int[] getTask();

    String getRenderedTask(int[] task);

    boolean checkSolution(int[] task, int input);
}
