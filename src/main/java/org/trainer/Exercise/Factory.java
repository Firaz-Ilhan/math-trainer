package org.trainer.Exercise;

import java.util.ArrayList;
import java.util.Random;

public class Factory {

    private Random rand = new Random();

    public String getRandomType(boolean addition, boolean multiplication) {

        ArrayList<String> typeList = new ArrayList<>(2);

        if (addition) {
            typeList.add("addition");
        }

        if (multiplication) {
            typeList.add("multiplication");
        }

        String randomElement = typeList.get(rand.nextInt(typeList.size()));
        return randomElement;
    }

    public Arithmetic getArithmetic(String arithmeticType, String difficulty) {

        if (arithmeticType == null) {
            return null;
        }
        if (arithmeticType.equalsIgnoreCase("addition")) {
            return new Addition(difficulty);
        } else if (arithmeticType.equalsIgnoreCase("multiplication")) {
            return new Multiplication(difficulty);
        }

        return null;
    }
}