package org.trainer;

import java.util.Random;

public class Exponent {

    private final char EXPONENT_SIGN = '^';
    public char getExponentSign() { return EXPONENT_SIGN; }
    private int result = 0;
    private final Random rand = new Random();

    //set a level
    //different constructors for different levels
    //return result separately
    public int getResult(){return result;}

    /** level 1 **/
    public String exponent1(){

        int num = rand.nextInt(10);

        result = num * num;
        return num + EXPONENT_SIGN + "2";
    }
    /** level 2 **/
    public String exponent2(){

        int num = rand.nextInt(100);

        result = num * num;
        return num + EXPONENT_SIGN + "2";
    }
    /** level 3 **/
    public String exponent3(){

        int num = rand.nextInt(10);

        result = num * num * num;
        return num + EXPONENT_SIGN + "3";
    }
    /** level 4 **/
    public String exponent4(){

        int num = rand.nextInt(100);

        result = num * num;
        return num + EXPONENT_SIGN + "2";
    }
}

