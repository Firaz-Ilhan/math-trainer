package org.trainer.Exercise;

import java.util.Random;

public class Exercise {

    protected final Random rand = new Random();

    public int getSolution(int[] task) {
        return task[task.length - 1];
    }
}
