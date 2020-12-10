package org.trainer;

import org.junit.Assert;
import org.junit.Test;
import org.trainer.Exercise.Addition;
import org.trainer.Exercise.Arithmetic;
import org.trainer.Exercise.Multiplication;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /* -- Addition -- */
    @Test public void test_addition_beginner() {
        Arithmetic add = new Addition("beginner");
        Assert.assertTrue( add.getSolution(add.getTask()) >= -34 && add.getSolution(add.getTask()) <= 80) ;
    }

    @Test public void test_addition_medium() {
        Arithmetic add = new Addition("medium");
        Assert.assertTrue( add.getSolution(add.getTask()) >= 22 && add.getSolution(add.getTask()) <= 82) ;
    }

    @Test public void test_addition_hard() {
        Arithmetic add = new Addition("hard");
        Assert.assertTrue( add.getSolution(add.getTask()) >= 42 && add.getSolution(add.getTask()) <= 102) ;
    }

    /* -- Multiplication -- */
    @Test public void test_multiplication_beginner() {
        Arithmetic multi = new Multiplication("beginner");
        Assert.assertTrue(multi.getSolution(multi.getTask()) >= -49 && multi.getSolution(multi.getTask()) <= 400);
    }

    @Test public void test_multiplication_medium() {
        Arithmetic multi = new Multiplication("medium");
        Assert.assertTrue(multi.getSolution(multi.getTask()) >= 1 && multi.getSolution(multi.getTask()) <= 361);
    }

    @Test public void test_multiplication_hard() {
        Arithmetic multi = new Multiplication("hard");
        Assert.assertTrue(multi.getSolution(multi.getTask()) >= 36 && multi.getSolution(multi.getTask()) <= 441);
    }
}