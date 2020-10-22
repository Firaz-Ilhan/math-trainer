package org.trainer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Addition a1 = new Addition(5);

        try (final Scanner scanner = new Scanner(System.in)) {

            int userInput;

            for (int i = 0; i < a1.getNumberOfTasks(); i++) {
                int result[] = a1.getAddition();
                int rnd1 = result[0];
                int rnd2 = result[1];
                int sum = result[2];

                System.out.println("calculate: " + rnd1 + " + " + rnd2);

                userInput = scanner.nextInt();
                if (userInput == sum) {
                    System.out.println(userInput + " is correct");
                } else {
                    System.out.println(userInput + " isn't correct. " + sum + " is correct");
                }
            }
        }
    }
}
