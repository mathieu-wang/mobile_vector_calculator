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
        Assert.assertEquals(-2.9, result.getX(), PRECISION);
        Assert.assertEquals(-3.9, result.getY(), PRECISION);
    }

    @Test
    public void testLargestValidTwoCartesianVectorsAddition(){
        CartesianVector a = new CartesianVector(10e12, 10e12);
        CartesianVector b = new CartesianVector(10e12, 10e12);
        CartesianVector result = Calculator.addTwoCartesianVectors(a, b);
        Assert.assertEquals(2*10e12, result.getX(), PRECISION);
        Assert.assertEquals(2*10e12, result.getY(), PRECISION);
    }

    @Test
    public void testSmallestValidTwoCartesianVectorsAddition(){
        CartesianVector a = new CartesianVector(-10e12, -10e12);
        CartesianVector b = new CartesianVector(-10e12, -10e12);
        CartesianVector result = Calculator.addTwoCartesianVectors(a, b);
        Assert.assertEquals(-2*10e12, result.getX(), PRECISION);
        Assert.assertEquals(-2*10e12, result.getY(), PRECISION);
    }

    @Test
    public void testValidTwoPolarVectorsAddition(){
        PolarVector a = new PolarVector(1.5, -30.6);
        PolarVector b = new PolarVector(2.3, 770);
        PolarVector result = Calculator.addTwoPolarVectors(a, b);
        Assert.assertEquals(2.944, result.getR(), PRECISION);
        Assert.assertEquals(19.82288, result.getTheta(), PRECISION);
    }

    @Test
    public void testLargestValidTwoPolarVectorsAddition(){
        PolarVector a = new PolarVector(10e12, 10e12);
        PolarVector b = new PolarVector(10e12, 10e12);
        PolarVector result = Calculator.addTwoPolarVectors(a, b);
        Assert.assertEquals(2*10e12, result.getR(), PRECISION);
        Assert.assertEquals(-80.000275, result.getTheta(), PRECISION);
    }

    @Test
    public void testSmallestValidTwoPolarVectorsAddition(){
        PolarVector a = new PolarVector(10e12, -10e12);
        PolarVector b = new PolarVector(10e12, -10e12);
        PolarVector result = Calculator.addTwoPolarVectors(a, b);
        Assert.assertEquals(2*10e12, result.getR(), PRECISION);
        Assert.assertEquals(80.000275, result.getTheta(), PRECISION);
    }

    @Test
    public void testValidThreeCartesianVectorsAddition(){
        CartesianVector a = new CartesianVector(2.2, -1);
        CartesianVector b = new CartesianVector(-5.1, -2.9);
        CartesianVector c = new CartesianVector(100000.1, -999999.2);
        CartesianVector result = Calculator.addThreeCartesianVectors(a, b, c);
        Assert.assertEquals(99997.2, result.getX(), PRECISION);
        Assert.assertEquals(-1000003.1, result.getY(), PRECISION);
    }

    @Test
    public void testLargestValidThreeCartesianVectorsAddition(){
        CartesianVector a = new CartesianVector(10e12, 10e12);
        CartesianVector b = new CartesianVector(10e12, 10e12);
        CartesianVector c = new CartesianVector(10e12, 10e12);
        CartesianVector result = Calculator.addThreeCartesianVectors(a, b, c);
        Assert.assertEquals(3*10e12, result.getX(), PRECISION);
        Assert.assertEquals(3*10e12, result.getY(), PRECISION);
    }

    @Test
    public void testSmallestValidThreeCartesianVectorsAddition(){
        CartesianVector a = new CartesianVector(-10e12, -10e12);
        CartesianVector b = new CartesianVector(-10e12, -10e12);
        CartesianVector c = new CartesianVector(-10e12, -10e12);
        CartesianVector result = Calculator.addThreeCartesianVectors(a, b, c);
        Assert.assertEquals(-3*10e12, result.getX(), PRECISION);
        Assert.assertEquals(-3*10e12, result.getY(), PRECISION);
    }

    @Test
    public void testValidThreePolarVectorsAddition(){
        PolarVector a = new PolarVector(1.5, -30.6);
        PolarVector b = new PolarVector(2.3, 770);
        PolarVector c = new PolarVector(100000, 12.2);
        PolarVector result = Calculator.addThreePolarVectors(a, b, c);
        Assert.assertEquals(100002.918, result.getR(), PRECISION);
        Assert.assertEquals(12.20022, result.getTheta(), PRECISION);
    }

    @Test
    public void testLargestValidThreePolarVectorsAddition(){
        PolarVector a = new PolarVector(10e12, 10e12);
        PolarVector b = new PolarVector(10e12, 10e12);
        PolarVector c = new PolarVector(10e12, 10e12);
        PolarVector result = Calculator.addThreePolarVectors(a, b, c);
        Assert.assertEquals(3.0000000000000004E13, result.getR(), PRECISION);
        Assert.assertEquals(-80.000275, result.getTheta(), PRECISION);
    }

    @Test
    public void testSmallestValidThreePolarVectorsAddition(){
        PolarVector a = new PolarVector(10e12, -10e12);
        PolarVector b = new PolarVector(10e12, -10e12);
        PolarVector c = new PolarVector(10e12, -10e12);
        PolarVector result = Calculator.addThreePolarVectors(a, b, c);
        Assert.assertEquals(3.0000000000000004E13, result.getR(), PRECISION);
        Assert.assertEquals(80.000275, result.getTheta(), PRECISION);
    }

    @Test
    public void testValidCartesianVectorsScalarProduct(){
        CartesianVector a = new CartesianVector(2.5, 3.6);
        CartesianVector b = new CartesianVector(20.5, -2.97);
        double result = Calculator.cartesianVectorsScalarProduct(a, b);
        Assert.assertEquals(40.558, result, PRECISION);
    }

    @Test
    public void testLargestValidCartesianVectorsScalarProduct(){
        CartesianVector a = new CartesianVector(10e12, 10e12);
        CartesianVector b = new CartesianVector(10e12, 10e12);
        double result = Calculator.cartesianVectorsScalarProduct(a, b);
        Assert.assertEquals(2.0E26, result, PRECISION);
    }

    @Test
    public void testSmallestValidCartesianVectorsScalarProduct(){
        CartesianVector a = new CartesianVector(-10e12, -10e12);
        CartesianVector b = new CartesianVector(-10e12, -10e12);
        double result = Calculator.cartesianVectorsScalarProduct(a, b);
        Assert.assertEquals(2.0E26, result, PRECISION);
    }

    @Test
    public void testValidPolarVectorsScalarProduct(){
        PolarVector a = new PolarVector(1.5, -30.6);
        PolarVector b = new PolarVector(2.3, 770);
        double result = Calculator.polarVectorsScalarProduct(a, b);
        Assert.assertEquals(0.56347, result, PRECISION);
    }

    @Test
    public void testLargestValidPolarVectorsScalarProduct(){
        PolarVector a = new PolarVector(10e12, 10e12);
        PolarVector b = new PolarVector(10e12, 10e12);
        double result = Calculator.polarVectorsScalarProduct(a, b);
        Assert.assertEquals(1.0E26, result, PRECISION);
    }

    @Test
    public void testSmallestValidPolarVectorsScalarProduct(){
        PolarVector a = new PolarVector(10e12, -10e12);
        PolarVector b = new PolarVector(10e12, -10e12);
        double result = Calculator.polarVectorsScalarProduct(a, b);
        Assert.assertEquals(1.0E26, result, PRECISION);
    }

    @Test
    public void testValidCartesianVectorsVectorProduct(){
        CartesianVector a = new CartesianVector(2.5, 3.6);
        CartesianVector b = new CartesianVector(20.5, -2.97);
        double result = Calculator.cartesianVectorsVectorProduct(a, b);
        Assert.assertEquals(-81.225, result, PRECISION);
    }

    @Test
    public void testLargestValidCartesianVectorsVectorProduct(){
        CartesianVector a = new CartesianVector(10e12, 10e12);
        CartesianVector b = new CartesianVector(10e12, 10e12);
        double result = Calculator.cartesianVectorsVectorProduct(a, b);
        Assert.assertEquals(0, result, PRECISION);
    }

    @Test
    public void testSmallestValidCartesianVectorsVectorProduct(){
        CartesianVector a = new CartesianVector(-10e12, -10e12);
        CartesianVector b = new CartesianVector(-10e12, -10e12);
        double result = Calculator.cartesianVectorsVectorProduct(a, b);
        Assert.assertEquals(0, result, PRECISION);
    }

    @Test
    public void testValidPolarVectorsVectorProduct(){
        PolarVector a = new PolarVector(1.5, -30.6);
        PolarVector b = new PolarVector(2.3, 770);
        double result = Calculator.polarVectorsVectorProduct(a, b);
        Assert.assertEquals(3.403673957544043, result, PRECISION);
    }

    @Test
    public void testLargestValidPolarVectorsVectorProduct(){
        PolarVector a = new PolarVector(10e12, 10e12);
        PolarVector b = new PolarVector(10e12, 10e12);
        double result = Calculator.polarVectorsVectorProduct(a, b);
        Assert.assertEquals(0, result, PRECISION);
    }

    @Test
    public void testSmallestValidPolarVectorsVectorProduct(){
        PolarVector a = new PolarVector(10e12, -10e12);
        PolarVector b = new PolarVector(10e12, -10e12);
        double result = Calculator.polarVectorsVectorProduct(a, b);
        Assert.assertEquals(0, result, PRECISION);
    }

}
