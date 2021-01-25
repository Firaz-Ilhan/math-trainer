package org.trainer.modelOld;

import java.util.Random;
import java.util.regex.Pattern;

public class Task {

    final Random RAND = new Random();
    private final Pattern pattern = Pattern.compile("-?[0-9]{0,10}");

    final String BEGINNER = "beginner";
    final String MEDIUM = "medium";
    final String HARD = "hard";

    /**
     * Checks if the user input matches the calculated solution.
     *
     * @param task  int array with task numbers and solution.
     * @param input the users input.
     * @return true if solved successfully.
     */
    public boolean checkSolution(int[] task, int input) {
        if (task == null || task.length == 0) {
            return false;
        } else {
            return input == task[task.length - 1];
        }
    }

    /**
     * Returns the solution provided in the last array index.
     *
     * @param task int array with task numbers and solution.
     * @return solution int.
     */
    public int getSolution(int[] task) {
        return task[task.length - 1];
    }

    /**
     * Checks if the user userInput matches the regular expression
     *
     * @param userInput user userInput
     * @return true if userInput matches regular expression
     */
    public boolean checkInputPattern(String userInput) {
        if (userInput.isEmpty()) {
            return false;
        } else {
            return pattern.matcher(userInput).matches();
        }
    }
}