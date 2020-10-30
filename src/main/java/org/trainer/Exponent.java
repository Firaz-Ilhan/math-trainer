package org.trainer;

import java.util.Random;

public class Exponent {

    private final char EXPONENT_SIGN = '^';
    public char getExponentSign() { return EXPONENT_SIGN; }
    private final Random rand = new Random();

    //get level from Gui??
    //private final int level = getLevel(){;}
    private int level = 0;
    //different constructors for different levels
    public Exponent(int level){
        this.level = level;}


    public int[] getExponentExercise(int level){  //replace level with getLevel(){;}
        this.level = level;
        if(level == 0){
            int num = rand.nextInt(10);
            return new int[]{num, num * num}; //String: num ^2 = ? ---User input --- check if Input == num * num
        }
        else if(level == 1){
            int num = rand.nextInt(100);
            return new int[]{num, num * num};
        }
        else if(level == 2){
            int num = rand.nextInt(10);
            return new int[]{num, num * num * num};
        }
        else if(level == 3){
            int num = rand.nextInt(100);
            return new int[]{num, num * num * num};
        }
        return new int[0];
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

