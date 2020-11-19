package org.trainer;

public class Factory {

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

