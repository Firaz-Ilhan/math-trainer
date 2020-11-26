package org.trainer.Exercise;

import java.util.Random;

public class Subtraction implements Arithmetic {


        Random rand = new Random();

        private String difficulty;

        public Subtraction(String difficulty) {
            this.difficulty = difficulty.toLowerCase();
        }

        @Override
        public String getDifficulty() {
            return difficulty;
        }

        @Override
        public void setDifficulty(String difficulty) {
            this.difficulty = difficulty;
        }

        @Override
        public int[] getTask() {
            int max = 0, min = 0, rand1, rand2, sum;

            switch (difficulty) {
                case "easy":
                    max = 20;
                    min = 1;
                    break;
                case "medium":
                    max = 30;
                    min = 20;
                    break;
                case "hard":
                    max = 40;
                    min = 30;
                    break;

            }

            rand1 = rand.nextInt((max - min) + 1) + min;
            rand2 = rand.nextInt((max - min) + 1) + min;
            sum = rand1 - rand2;

            return new int[]{rand1, rand2, sum};
        }

        @Override
        public String getRenderedTask(int[] task) {
            return task[0] + "-" + task[1];
        }

        @Override
        public boolean checkSolution(int[] task, int input) {
            if (task == null || task.length == 0) {
                return false;
            } else {
                return input == task[2];
            }
        }


}
