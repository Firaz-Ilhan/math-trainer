package org.trainer;

import java.util.Random;

public class Exponent {

    private final char EXPONENT_SIGN = '^';
    public char getExponentSign() { return EXPONENT_SIGN; }
    private final Random rand = new Random();

    private String level;

    public Exponent(String level){
        this.level = level;}


    public int[] getExponentExercise(){
    // public String getExponentExercise(){
        switch (level) {
            case "beginner": {
                int num = rand.nextInt(9)+1; //1-10
                return new int[]{num, num * num};
                // return num + "^" + 2 + " = ";
                //break; unreachable?!
            }
            case "medium": {
                int num = rand.nextInt(89)+11; //11-100
                return new int[]{num, num * num};
                /*
                int[] calcNum = {num};
                setNumber(calcNum);
                int result = num * num;
                setResult(result);
                return num + "^" + 2 + " = ";
                */
                break;
            }
            case "hard": {
                int num = rand.nextInt(9)+1; //1-10
                return new int[]{num, num * num * num};
                // return num + "^" + 3 + " = ";
                break;
            }
            case "pro": {
                int num = rand.nextInt(89)+11; //11-100
                return new int[]{num, num * num * num};
                // return num + "^" + 3 + " = ";
                break;
            }
            default: return new int[0];
        }
    }

    /** level 0 **/
    public int[] exponent0(){
        int num = rand.nextInt(10);
        return new int[]{num, num * num};
    }
    /** level 1 **/
    public int[] exponent1(){
        int num = rand.nextInt(100); //exclude below 10
        return new int[]{num, num * num};
    }
    /** level 2 **/
    public int[] exponent2(){
        int num = rand.nextInt(10);
        return new int[]{num, num * num * num};
    }
    /** level 3 **/
    public int[] exponent3(){

        int num = rand.nextInt(100); //exclude below 10
        return new int[]{num, num * num * num};
    }
}

