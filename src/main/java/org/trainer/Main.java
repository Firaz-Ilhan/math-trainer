package org.trainer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Factory f1 = new Factory();

        Arithmetic add = f1.getArithmetic("addition", "medium");

        try (final Scanner scanner = new Scanner(System.in)) {

            int userInput;

            for (int i = 0; i < 10; i++) {
                int[] result = add.getTask();
                System.out.println("calculate: " + result[0] + add.getSign() + result[1]);

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
