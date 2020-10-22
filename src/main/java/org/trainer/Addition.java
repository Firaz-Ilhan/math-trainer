package org.trainer;

public class Addition {

    private int numberOfTasks;

    private RandomNumberGenerator r1 = new RandomNumberGenerator(1, 10);

    public Addition(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    public void setNumberOfTasks(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }

    public int[] getAddition() {

        int rnd1 = r1.getRandom(r1.getMinValue(), r1.getMaxValue());
        int rnd2 = r1.getRandom(r1.getMinValue(), r1.getMaxValue());
        int sum = rnd1 + rnd2;

        return new int[] {rnd1, rnd2, sum};
    }
}
