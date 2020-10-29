package org.trainer;

import java.util.Random;

public class Exponent {

    private final char EXPONENT_SIGN = '^';
    public char getExponentSign() { return EXPONENT_SIGN; }
    private final Random rand = new Random();

    //set a level
    //different constructors for different levels
    
    /** level 1 **/
    public int[] exponent1(){
        int num = rand.nextInt(10);
        return new int[]{num, num * num};
    }
    /** level 2 **/
    public int[] exponent2(){
        int num = rand.nextInt(100); //exclude below 10
        return new int[]{num, num * num};
    }
    /** level 3 **/
    public int[] exponent3(){
        int num = rand.nextInt(10);
        return new int[]{num, num * num * num};
    }
    /** level 4 **/
    public int[] exponent4(){

        int num = rand.nextInt(100); //exclude below 10
        return new int[]{num, num * num * num};
    }
}

