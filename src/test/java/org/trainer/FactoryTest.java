package org.trainer;

import org.junit.Assert;
import org.junit.Test;
import org.trainer.exceptions.IllegalFactoryArgument;
import org.trainer.model.*;

public class FactoryTest {

    final private Factory factory = new Factory();

    @Test
    public void test_addition() throws IllegalFactoryArgument {
        Arithmetic addition = factory.getArithmetic("addition", "beginner");
        Assert.assertTrue(addition instanceof Addition);
    }

    @Test
    public void test_subtraction() throws IllegalFactoryArgument {
        Arithmetic subtraction = factory.getArithmetic("subtraction", "beginner");
        Assert.assertTrue(subtraction instanceof Subtraction);
    }

    @Test
    public void test_multiplication() throws IllegalFactoryArgument {
        Arithmetic multiplication = factory.getArithmetic("multiplication", "beginner");
        Assert.assertTrue(multiplication instanceof Multiplication);
    }

    @Test
    public void test_Division() throws IllegalFactoryArgument {
        Arithmetic division = factory.getArithmetic("division", "beginner");
        Assert.assertTrue(division instanceof Division);
    }

    @Test
    public void test_Exponent() throws IllegalFactoryArgument {
        Arithmetic exponent = factory.getArithmetic("exponent", "beginner");
        Assert.assertTrue(exponent instanceof Exponent);
    }

    @Test
    public void test_Root() throws IllegalFactoryArgument {
        Arithmetic root = factory.getArithmetic("root", "beginner");
        Assert.assertTrue(root instanceof Root);
    }

    @Test
    public void test_OrderOfOperation() throws IllegalFactoryArgument {
        Arithmetic orderOfOperation = factory.getArithmetic("orderofoperation", "beginner");
        Assert.assertTrue(orderOfOperation instanceof OrderOfOperation);
    }

    @Test
    public void test_negative() throws IllegalFactoryArgument {
        Arithmetic addition = factory.getArithmetic("addition", "beginner");
        Arithmetic subtraction = factory.getArithmetic("subtraction", "beginner");
        Arithmetic multiplication = factory.getArithmetic("multiplication", "beginner");
        Arithmetic division = factory.getArithmetic("division", "beginner");
        Arithmetic exponent = factory.getArithmetic("exponent", "beginner");
        Arithmetic root = factory.getArithmetic("root", "beginner");
        Arithmetic orderOfOperation = factory.getArithmetic("orderofoperation", "beginner");

        Assert.assertFalse(addition instanceof Subtraction);
        Assert.assertFalse(subtraction instanceof Multiplication);
        Assert.assertFalse(multiplication instanceof Division);
        Assert.assertFalse(division instanceof Exponent);
        Assert.assertFalse(exponent instanceof Root);
        Assert.assertFalse(root instanceof OrderOfOperation);
        Assert.assertFalse(orderOfOperation instanceof Addition);
    }
}
