package org.trainer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.trainer.Exercise.Arithmetic;
import org.trainer.Exercise.Factory;
import org.trainer.exceptions.IllegalFactoryArgument;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final Logger log = LogManager.getLogger(Main.class);
        Factory f1 = new Factory();

        try (final Scanner scanner = new Scanner(System.in)) {

            int userInput;

            do {
                String randomType = f1.getRandomType(true, true, true, true, true);

                Arithmetic task = f1.getArithmetic(randomType, "medium");

                int[] arr = task.getTask();
                System.out.println("calculate: " + task.getRenderedTask(arr));

                userInput = scanner.nextInt();

                if (task.checkSolution(arr, userInput)) {
                    System.out.println(userInput + " is correct");
                } else {
                    System.out.println(userInput + " isn't correct. Correct Answer: " + task.getSolution(arr));
                }
            } while (true);
        } catch (IllegalFactoryArgument e1) {
            log.error(e1.toString());
            e1.printStackTrace();
        }
    }
}
