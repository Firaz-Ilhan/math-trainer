package org.trainer;

import org.junit.Assert;
import org.junit.Test;
import org.trainer.model.*;

/**
 * Unit test for simple App.
 */
public class ArithmeticTest {

    /* -- Addition -- */
    @Test
    public void test_addition_beginner() {
        Arithmetic add = new Addition("beginner");
        int result = add.getSolution(add.getTask());
        Assert.assertTrue(result >= 2 && result <= 40);
    }

    @Test
    public void test_addition_medium() {
        Arithmetic add = new Addition("medium");
        int result = add.getSolution(add.getTask());
        Assert.assertTrue(result >= 40 && result <= 60);
    }

    @Test
    public void test_addition_hard() {
        Arithmetic add = new Addition("hard");
        int result = add.getSolution(add.getTask());
        Assert.assertTrue(result >= 60 && result <= 80);
    }

    /* -- Subtraction -- */
    @Test
    public void test_subtraction_beginner() {
        Arithmetic add = new Subtraction("beginner");
        int result = add.getSolution(add.getTask());
        Assert.assertTrue(result >= -19 && result <= 19);
    }

    @Test
    public void test_subtraction_medium() {
        Arithmetic add = new Subtraction("medium");
        int result = add.getSolution(add.getTask());
        Assert.assertTrue(result >= -10 && result <= 10);
    }

    @Test
    public void test_subtraction_hard() {
        Arithmetic add = new Subtraction("hard");
        int result = add.getSolution(add.getTask());
        Assert.assertTrue(result >= -10 && result <= 10);
    }

    /* -- Multiplication -- */
    @Test
    public void test_multiplication_beginner() {
        Arithmetic multi = new Multiplication("beginner");
        int result = multi.getSolution(multi.getTask());
        Assert.assertTrue(result >= 2 && result <= 100);
    }

    @Test
    public void test_multiplication_medium() {
        Arithmetic multi = new Multiplication("medium");
        int result = multi.getSolution(multi.getTask());
        Assert.assertTrue(result >= 36 && result <= 144);
    }

    @Test
    public void test_multiplication_hard() {
        Arithmetic multi = new Multiplication("hard");
        int result = multi.getSolution(multi.getTask());
        Assert.assertTrue(result >= 100 && result <= 225);
    }

    /* -- Division -- */
    @Test
    public void test_division_beginner() {
        Arithmetic divi = new Division("beginner");
        int result = divi.getSolution(divi.getTask());
        Assert.assertTrue(result >= 1 && result <= 10);
    }

    @Test
    public void test_division_medium() {
        Arithmetic divi = new Division("medium");
        int result = divi.getSolution(divi.getTask());
        Assert.assertTrue(result >= 6 && result <= 12);
    }

    @Test
    public void test_division_hard() {
        Arithmetic divi = new Division("hard");
        int result = divi.getSolution(divi.getTask());
        Assert.assertTrue(result >= 10 && result <= 15);
    }

    /* -- Exponent -- */
    @Test
    public void test_exponent_beginner() {
        Arithmetic expo = new Exponent("beginner");
        int result = expo.getSolution(expo.getTask());
        Assert.assertTrue(result >= 1 && result <= 100);
    }

    @Test
    public void test_exponent_medium() {
        Arithmetic expo = new Exponent("medium");
        int result = expo.getSolution(expo.getTask());
        Assert.assertTrue(result >= 25 && result <= 400);
    }

    @Test
    public void test_exponent_hard() {
        Arithmetic expo = new Exponent("hard");
        int result = expo.getSolution(expo.getTask());
        Assert.assertTrue(result >= 1 && result <= 1000);
    }

    /* -- Root -- */
    @Test
    public void test_root_beginner() {
        Arithmetic root = new Root("beginner");
        int result = root.getSolution(root.getTask());
        Assert.assertTrue(result >= 1 && result <= 8);
    }

    @Test
    public void test_root_medium() {
        Arithmetic root = new Root("medium");
        int result = root.getSolution(root.getTask());
        Assert.assertTrue(result >= 8 && result <= 20);
    }

    @Test
    public void test_root_hard() {
        Arithmetic root = new Root("hard");
        int result = root.getSolution(root.getTask());
        Assert.assertTrue(result >= 3 && result <= 15);
    }

    /* -- OrderOfOperation -- */
    @Test
    public void test_orderOfOperation_beginner() {
        Arithmetic order = new OrderOfOperation("beginner");
        int result = order.getSolution(order.getTask());
        Assert.assertTrue(result >= 2 && result <= 110);
    }

    @Test
    public void test_orderOfOperation_medium() {
        Arithmetic order = new OrderOfOperation("medium");
        int result = order.getSolution(order.getTask());
        Assert.assertTrue(result >= 132 && result <= 240);
    }

    @Test
    public void test_orderOfOperation_hard() {
        Arithmetic order = new OrderOfOperation("hard");
        int result = order.getSolution(order.getTask());
        Assert.assertTrue(result >= 272 && result <= 420);
    }
}