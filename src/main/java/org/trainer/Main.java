package org.trainer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Factory f1 = new Factory();

        try (final Scanner scanner = new Scanner(System.in)) {

            int userInput;

            do {
                String randomType = f1.getRandomType(true, true);

                Arithmetic task = f1.getArithmetic(randomType, "easy");

                int[] result = task.getTask();
                System.out.println("calculate: " + result[0] + task.getSign() + result[1]);

                userInput = scanner.nextInt();
                if (userInput == result[2]) {
                    System.out.println(userInput + " is correct");
                } else {
                    System.out.println(userInput + " isn't correct. " + result[2] + " is correct");
                }
            } while (true);
        }
    }
}
