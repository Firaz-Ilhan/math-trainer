package org.trainer;

public class Addition extends Arithmetic {

    private final char ADDITION_SIGN = '+';

    public char getAdditionSign() {
        return ADDITION_SIGN;
    }

    public int[] getAddition() {
        int rnd1 = r1.getRandom(r1.getMinValue(), r1.getMaxValue());
        int rnd2 = r1.getRandom(r1.getMinValue(), r1.getMaxValue());
        int sum = rnd1 + rnd2;

        return new int[] {rnd1, rnd2, sum};
    }
}
