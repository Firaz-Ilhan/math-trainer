package org.trainer;

import org.junit.Assert;
import org.junit.Test;
import org.trainer.exceptions.IllegalFactoryArgument;
import org.trainer.modelOld.*;

public class FactoryTest {

    private final String ADDITION = "addition";
    private final String BEGINNER = "beginner";
    private final String SUBTRACTION = "subtraction";
    private final String MULTIPLICATION = "multiplication";
    private final String DIVISION = "division";
    private final String EXPONENT = "exponent";
    private final String ORDER_OF_OPERATION = "orderofoperation";
    final private Factory factory = new Factory();

    @Test
    public void test_addition() throws IllegalFactoryArgument {
        Arithmetic addition = factory.getArithmetic(ADDITION, BEGINNER);
        Assert.assertTrue(addition instanceof Addition);
    }

    @Test
    public void test_subtraction() throws IllegalFactoryArgument {
        Arithmetic subtraction = factory.getArithmetic(SUBTRACTION, BEGINNER);
        Assert.assertTrue(subtraction instanceof Subtraction);
    }

    @Test
    public void test_multiplication() throws IllegalFactoryArgument {
        Arithmetic multiplication = factory.getArithmetic(MULTIPLICATION, BEGINNER);
        Assert.assertTrue(multiplication instanceof Multiplication);
    }

    @Test
    public void test_Division() throws IllegalFactoryArgument {
        Arithmetic division = factory.getArithmetic(DIVISION, BEGINNER);
        Assert.assertTrue(division instanceof Division);
    }

    @Test
    public void test_Exponent() throws IllegalFactoryArgument {
        Arithmetic exponent = factory.getArithmetic(EXPONENT, BEGINNER);
        Assert.assertTrue(exponent instanceof Exponent);
    }

    @Test
    public void test_Root() throws IllegalFactoryArgument {
        Arithmetic root = factory.getArithmetic("root", BEGINNER);
        Assert.assertTrue(root instanceof Root);
    }

    @Test
    public void test_OrderOfOperation() throws IllegalFactoryArgument {
        Arithmetic orderOfOperation = factory.getArithmetic(ORDER_OF_OPERATION, BEGINNER);
        Assert.assertTrue(orderOfOperation instanceof OrderOfOperation);
    }

    @Test
    public void test_negative() throws IllegalFactoryArgument {
        Arithmetic addition = factory.getArithmetic(ADDITION, BEGINNER);
        Arithmetic subtraction = factory.getArithmetic(SUBTRACTION, BEGINNER);
        Arithmetic multiplication = factory.getArithmetic(MULTIPLICATION, BEGINNER);
        Arithmetic division = factory.getArithmetic(DIVISION, BEGINNER);
        Arithmetic exponent = factory.getArithmetic(EXPONENT, BEGINNER);
        Arithmetic root = factory.getArithmetic("root", BEGINNER);
        Arithmetic orderOfOperation = factory.getArithmetic(ORDER_OF_OPERATION, BEGINNER);

        Assert.assertFalse(addition instanceof Subtraction);
        Assert.assertFalse(subtraction instanceof Multiplication);
        Assert.assertFalse(multiplication instanceof Division);
        Assert.assertFalse(division instanceof Exponent);
        Assert.assertFalse(exponent instanceof Root);
        Assert.assertFalse(root instanceof OrderOfOperation);
        Assert.assertFalse(orderOfOperation instanceof Addition);
    }

    @Test(expected = IllegalFactoryArgument.class)
    public void test_factory_exception() throws IllegalFactoryArgument {
        factory.getArithmetic("abc", "def");
    }
}
