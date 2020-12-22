package org.trainer.model;

public enum ArithmeticType {

    ADDITION("addition"),
    SUBTRACTION("subtraction"),
    MULTIPLICATION("multiplication"),
    DIVISION("division"),
    ORDER_OF_OPERATION("orderofoperation"),
    EXPONENT("exponent"),
    ROOT("root");

    private final String type;

    ArithmeticType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
