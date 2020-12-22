package org.trainer.model;

import java.util.Random;

public class Task {

    final Random rand = new Random();

    public boolean checkSolution(int[] task, int input) {
        if (task == null || task.length == 0) {
            return false;
        } else {
            return input == task[task.length - 1];
        }
    }

    public int getSolution(int[] task) {
        return task[task.length - 1];
    }
}
