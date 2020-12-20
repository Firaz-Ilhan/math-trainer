package org.trainer.exercise;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.trainer.exceptions.IllegalFactoryArgument;

import java.util.ArrayList;
import java.util.Random;

public class Factory {

    private final Random rand = new Random();
    private static final Logger log = LogManager.getLogger(Factory.class);

    public String getRandomType(boolean addition, boolean subtraction, boolean multiplication,
                                boolean orderOfOperation, boolean exponent, boolean root, boolean division) {

        ArrayList<String> typeList = new ArrayList<>(7);

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

        if (root) {
            typeList.add("root");
        }

        if (division) {
            typeList.add("division");
        }

        return typeList.get(rand.nextInt(typeList.size()));
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
            case "root":
                return new Root(difficulty);
            case "division":
                return new Division(difficulty);
            default:
                log.error("Type not found");
                throw new IllegalFactoryArgument("Invalid type of Arithmetic");
        }
    }
}