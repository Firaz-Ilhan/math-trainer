package org.trainer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.trainer.exceptions.IllegalFactoryArgument;
import org.trainer.model.Arithmetic;
import org.trainer.model.Factory;
import org.trainer.statistics.Statistics;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final Logger log = LogManager.getLogger(Main.class);
        Factory f1 = new Factory();
        Statistics statCollector = new Statistics();

        try (final Scanner scanner = new Scanner(System.in)) {

            int userInput;
            boolean loop = true;

            System.out.println("enter 9999 to exit\n");

            ArrayList<String> type = new ArrayList<>(7);
            type.add("addition");
            type.add("subtraction");

            do {
                String randomType = f1.getRandomType(type);

                Arithmetic task = f1.getArithmetic(randomType, "medium");

                int[] arr = task.getTask();
                System.out.println("calculate: " + task.getRenderedTask(arr));

                userInput = scanner.nextInt();

                if (userInput == 9999) {
                    loop = false;
                } else if (task.checkSolution(arr, userInput)) {
                    System.out.println(userInput + " is correct\n");
                } else {
                    System.out.println(userInput + " isn't correct. Correct Answer: " + task.getSolution(arr) + "\n");
                }
                statCollector.collector(randomType, task.checkSolution(arr, userInput));
            } while (loop);
        } catch (IllegalFactoryArgument e1) {
            log.error(e1.toString());
            e1.printStackTrace();
        } finally {
            //stat
            System.out.println(statCollector.getStats(false));
            statCollector.statSaver();
        }
    }
}
