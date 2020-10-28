package org.trainer;

public abstract class Arithmetic {

    private int numberOfTask = 5;
    RandomNumberGenerator r1 = new RandomNumberGenerator(1, 25);

    public int getNumberOfTask() {
        return numberOfTask;
    }

    public void setNumberOfTask(int numberOfTask) {
        this.numberOfTask = numberOfTask;
    }
}
