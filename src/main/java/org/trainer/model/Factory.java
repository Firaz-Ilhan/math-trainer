package org.trainer.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.trainer.exceptions.IllegalFactoryArgument;

import java.util.ArrayList;
import java.util.Random;

public class Factory {

    private final Random rand = new Random();
    private static final Logger log = LogManager.getLogger(Factory.class);

    /**
     * Provides a random type for {@link #getArithmetic(String, String)}.
     *
     * @param ArithmeticType a collection of selected types.
     * @return a random type.
     */
    public String getRandomType(ArrayList<String> ArithmeticType) {

        ArrayList<String> typeList = new ArrayList<>(7);

        typeList.addAll(ArithmeticType);

        return typeList.get(rand.nextInt(typeList.size()));
    }

    /**
     * Provides an instance of a concrete class.
     *
     * @param arithmeticType a type which is provided by {@link #getRandomType(ArrayList)}.
     * @param difficulty     selected difficulty for all types
     * @return an instance of one type.
     * @throws IllegalFactoryArgument if type could not be found
     */
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
                log.error(arithmeticType + " Type not found");
                throw new IllegalFactoryArgument("Invalid type of Arithmetic");
        }
    }
}