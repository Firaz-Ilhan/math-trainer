package org.trainer;

import org.junit.Assert;
import org.junit.Test;
import org.trainer.Exercise.Addition;
import org.trainer.Exercise.Arithmetic;

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

}