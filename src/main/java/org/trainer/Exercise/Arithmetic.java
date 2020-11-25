package org.trainer.Exercise;

public interface Arithmetic {

    //char getSign();
    String getDifficulty();
    void setDifficulty(String difficulty);
    int[] getTask();
    public String getRenderedTask(int[] task);
    public boolean checkSolution(int[] task, int input);
}
