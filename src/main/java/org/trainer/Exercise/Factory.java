package org.trainer.Exercise;

import java.util.ArrayList;
import java.util.Random;

public class Factory {

    private Random rand = new Random();

    public String getRandomType(boolean addition, boolean subtraction, boolean multiplication, boolean exponent) {

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

        if (exponent) {
            typeList.add("exponent");
        }

        String randomElement = typeList.get(rand.nextInt(typeList.size()));
        return randomElement;
    }

    public Arithmetic getArithmetic(String arithmeticType, String difficulty) throws IllegalFactoryArgument {

        if (arithmeticType.equalsIgnoreCase("addition")) {
            return new Addition(difficulty);
        } else if (arithmeticType.equalsIgnoreCase("subtraction")) {
            return new Subtraction(difficulty);
        } else if (arithmeticType.equalsIgnoreCase("multiplication")) {
            return new Multiplication(difficulty);
        } else if (arithmeticType.equalsIgnoreCase("exponent")) {
            return new Exponent(difficulty);
        }

        throw new IllegalFactoryArgument("Invalid type of Arithmetic");
    }
}