package org.trainer.Exercise;

import org.trainer.Exercise.Exercise;

import java.util.Random;

public class Exponent extends Exercise {

    private final char EXPONENT_SIGN = '^';
    public char getExponentSign() { return EXPONENT_SIGN; }
    private final Random rand = new Random();


    public Exponent(String level){
        this.level = level;}

    @Override
    public String question(){
        switch (level) {
            case "beginner": {
                int num = rand.nextInt(9)+1; //1-10
                setResult(num * num);
                return num + "^" + 2 + " = ";
            }
            case "medium": {
                int num = rand.nextInt(89)+11; //11-100
                setResult(num * num);
                return num + "^" + 2 + " = ";

            }
            case "hard": {
                int num = rand.nextInt(9)+1; //1-10
                setResult(num * num * num);
                return num + "^" + 3 + " = ";
            }
            case "pro": {
                int num = rand.nextInt(89)+11; //11-100
                setResult(num * num * num);
                return num + "^" + 3 + " = ";
            }
            default: return "The level input does not seem to exist, check the patch notes for more information";
        }
    }


    public int[] getExponentExercise(){
    // public String getExponentExercise(){
        switch (level) {
            case "beginner": {
                int num = rand.nextInt(9)+1; //1-10
                return new int[]{num, num * num};
                // return num + "^" + 2 + " = ";
            }
            case "medium": {
                int num = rand.nextInt(89)+11; //11-100
                return new int[]{num, num * num};

                /*
                int[] calcNum = {num};
                setNumber(calcNum);??
                setResult(num * num);
                return num + "^" + 2 + " = ";
                */
            }
            case "hard": {
                int num = rand.nextInt(9)+1; //1-10
                return new int[]{num, num * num * num};
                // return num + "^" + 3 + " = ";
            }
            case "pro": {
                int num = rand.nextInt(89)+11; //11-100
                return new int[]{num, num * num * num};
                // return num + "^" + 3 + " = ";
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

