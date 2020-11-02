package org.trainer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Addition a1 = new Addition("easy", 5);

        System.out.println("Difficulty: " + a1.getDifficulty() + '\n'
                + "Tasks: " + a1.getAmountOfTasks() + '\n');


        try (final Scanner scanner = new Scanner(System.in)) {

            int userInput;

            for (int i = 0; i < a1.getAmountOfTasks(); i++) {
                int[] result = a1.getExercise();
                System.out.println("calculate: " + result[0] + a1.getSign() + result[1]);

                userInput = scanner.nextInt();
                if (userInput == result[2]) {
                    System.out.println(userInput + " is correct");
                } else {
                    System.out.println(userInput + " isn't correct. " + result[2] + " is correct");
                }
            }
        }
    }
}
