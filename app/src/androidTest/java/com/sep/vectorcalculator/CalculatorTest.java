package com.sep.vectorcalculator;

import android.test.ActivityTestCase;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by YK on 15-02-21.
 */
public class CalculatorTest {
    public static final double PRECISION = 10e-5;

    @Test
    public void testValidTwoCartesianVectorsAddition(){
        CartesianVector a = new CartesianVector(2.2, -1);
        CartesianVector b = new CartesianVector(-5.1, -2.9);
        CartesianVector result = Calculator.addTwoCartesianVectors(a, b);
        Assert.assertEquals(result.getX(), -2.9, PRECISION);
        Assert.assertEquals(result.getY(), -3.9, PRECISION);
    }

    @Test
    public void testLargestValidTwoCartesianVectorsAddition(){
        CartesianVector a = new CartesianVector(10e12, 10e12);
        CartesianVector b = new CartesianVector(10e12, 10e12);
        CartesianVector result = Calculator.addTwoCartesianVectors(a, b);
        Assert.assertEquals(result.getX(), 2*10e12, PRECISION);
        Assert.assertEquals(result.getY(), 2*10e12, PRECISION);
    }

    @Test
    public void testSmallestValidTwoCartesianVectorsAddition(){
        CartesianVector a = new CartesianVector(-10e12, -10e12);
        CartesianVector b = new CartesianVector(-10e12, -10e12);
        CartesianVector result = Calculator.addTwoCartesianVectors(a, b);
        Assert.assertEquals(result.getX(), -2*10e12, PRECISION);
        Assert.assertEquals(result.getY(), -2*10e12, PRECISION);
    }

    @Test
    public void testValidTwoPolarVectorsAddition(){
        PolarVector a = new PolarVector();
        PolarVector b = new PolarVector();
        PolarVector result = Calculator.addTwoPolarVectors(a, b);
        Assert.assertEquals(result.getR(), 2.944, PRECISION);
        Assert.assertEquals(result.getTheta(), 19.823, PRECISION);
    }

    @Test
    public void testLargestValidTwoPolarVectorsAddition(){
        PolarVector a = new PolarVector(10e12, 10e12);
        PolarVector b = new PolarVector(10e12, 10e12);
        PolarVector result = Calculator.addTwoPolarVectors(a, b);
        Assert.assertEquals(result.getR(), 2*10e12, PRECISION);
        Assert.assertEquals(result.getTheta(), -80, PRECISION);
    }

    @Test
    public void testSmallestValidTwoPolarVectorsAddition(){
        PolarVector a = new PolarVector(10e12, -10e12);
        PolarVector b = new PolarVector(10e12, -10e12);
        PolarVector result = Calculator.addTwoPolarVectors(a, b);
        Assert.assertEquals(result.getR(), 2*10e12, PRECISION);
        Assert.assertEquals(result.getTheta(), 80, PRECISION);
    }
}
