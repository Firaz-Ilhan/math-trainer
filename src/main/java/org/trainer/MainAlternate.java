package org.trainer;

import org.trainer.Exercise.Exercise;
import org.trainer.Exercise.Exponent;

import java.util.Scanner;

public class MainAlternate {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
            int userInputResult;
            String userInputTask;
            String userInputLevel;
            boolean breaker = false;

            System.out.println("Addition/Subtraction/Multiplication/Division/Exponential ");
            userInputTask = scanner.nextLine().toLowerCase();
            System.out.println("beginner/medium/hard/pro ");
            userInputLevel = scanner.nextLine().toLowerCase();

            switch(userInputTask){
                case "addition":
                case "subtraction":
                case "multiplication":
                case "division":
                case "exponential":
                    Exercise expo = new Exponent(userInputLevel);
                    while(!breaker){
                        System.out.print(expo.question());
                        userInputResult = scanner.nextInt();
                        //Exit button to set breaker true!
                        System.out.println(expo.isTrue(userInputResult));
                    }

            }

    }
}

