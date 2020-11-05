package org.trainer;

import java.util.Random;

public interface Arithmetic {

    Random rand = new Random();

    char getSign();
    int getAmountOfTasks();
    String getDifficulty();
    void setDifficulty(String difficulty);
    void setAmountOfTasks(int amountOfTask);
    int[] getTask();
}
