package org.trainer.Exercise;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.trainer.exceptions.IllegalFactoryArgument;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Factory {

    private Random rand = new Random();
    private static final Logger log = LogManager.getLogger(Factory.class);

    public String getRandomType(boolean addition, boolean subtraction, boolean multiplication,
                                boolean orderOfOperation, boolean exponent) {

        ArrayList<String> typeList = new ArrayList<>(4);

        if (addition) {
            typeList.add("addition");
        }

        if (subtraction) {
            typeList.add("subtraction");
        }

        if (multiplication) {
            typeList.add("multiplication");
        }

        if (orderOfOperation) {
            typeList.add("orderOfOperation");
        }

        if (exponent) {
            typeList.add("exponent");
        }

        String randomElement = typeList.get(rand.nextInt(typeList.size()));
        return randomElement;
    }

    public Arithmetic getArithmetic(String arithmeticType, String difficulty) throws IllegalFactoryArgument {

        switch (arithmeticType.toLowerCase()) {
            case "addition":
                return new Addition(difficulty);
            case "subtraction":
                return new Subtraction(difficulty);
            case "multiplication":
                return new Multiplication(difficulty);
            case "orderofoperation":
                return new OrderOfOperation(difficulty);
            case "exponent":
                return new Exponent(difficulty);
            default:
                log.error("Type not found");
                throw new IllegalFactoryArgument("Invalid type of Arithmetic");
        }
    }
}