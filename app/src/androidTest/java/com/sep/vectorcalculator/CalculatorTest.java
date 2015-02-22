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
    public void testValidTwoCartesianVectorsAddition() throws Exception {
        CartesianVector a = new CartesianVector(2.2, -1);
        CartesianVector b = new CartesianVector(-5.1, -2.9);
        CartesianVector result = Calculator.addTwoCartesianVectors(a, b);
        Assert.assertEquals(-2.9, result.getX(), PRECISION);
        Assert.assertEquals(-3.9, result.getY(), PRECISION);
    }

    @Test
    public void testLargestValidTwoCartesianVectorsAddition() throws Exception {
        CartesianVector a = new CartesianVector(10e12, 10e12);
        CartesianVector b = new CartesianVector(10e12, 10e12);
        CartesianVector result = Calculator.addTwoCartesianVectors(a, b);
        Assert.assertEquals(2*10e12, result.getX(), PRECISION);
        Assert.assertEquals(2*10e12, result.getY(), PRECISION);
    }

    @Test
    public void testSmallestValidTwoCartesianVectorsAddition() throws Exception {
        CartesianVector a = new CartesianVector(-10e12, -10e12);
        CartesianVector b = new CartesianVector(-10e12, -10e12);
        CartesianVector result = Calculator.addTwoCartesianVectors(a, b);
        Assert.assertEquals(-2*10e12, result.getX(), PRECISION);
        Assert.assertEquals(-2*10e12, result.getY(), PRECISION);
    }

    @Test
    public void testValidTwoPolarVectorsAddition() throws Exception {
        PolarVector a = new PolarVector(1.5, -30.6);
        PolarVector b = new PolarVector(2.3, 770);
        PolarVector result = Calculator.addTwoPolarVectors(a, b);
        Assert.assertEquals(2.944, result.getR(), PRECISION);
        Assert.assertEquals(19.82288, result.getTheta(), PRECISION);
    }

    @Test
    public void testLargestValidTwoPolarVectorsAddition() throws Exception {
        PolarVector a = new PolarVector(10e12, 10e12);
        PolarVector b = new PolarVector(10e12, 10e12);
        try{
            PolarVector result = Calculator.addTwoPolarVectors(a, b);
            Assert.assertEquals(2*10e12, result.getR(), PRECISION);
            Assert.assertEquals(-80.000275, result.getTheta(), PRECISION);
        } catch (Exception e){
            Assert.assertEquals("Magnitude too large", e.getMessage());
        }
    }

    @Test
    public void testSmallestValidTwoPolarVectorsAddition() throws Exception {
        PolarVector a = new PolarVector(10e12, -10e12);
        PolarVector b = new PolarVector(10e12, -10e12);
        try {
            PolarVector result = Calculator.addTwoPolarVectors(a, b);
            Assert.assertEquals(2 * 10e12, result.getR(), PRECISION);
            Assert.assertEquals(80.000275, result.getTheta(), PRECISION);
        } catch (Exception e){
        Assert.assertEquals("Magnitude too large", e.getMessage());
        }
    }

    @Test
    public void testValidThreeCartesianVectorsAddition() throws Exception {
        CartesianVector a = new CartesianVector(2.2, -1);
        CartesianVector b = new CartesianVector(-5.1, -2.9);
        CartesianVector c = new CartesianVector(100000.1, -999999.2);
        CartesianVector result = Calculator.addThreeCartesianVectors(a, b, c);
        Assert.assertEquals(99997.2, result.getX(), PRECISION);
        Assert.assertEquals(-1000003.1, result.getY(), PRECISION);
    }

    @Test
    public void testLargestValidThreeCartesianVectorsAddition() throws Exception {
        CartesianVector a = new CartesianVector(10e12, 10e12);
        CartesianVector b = new CartesianVector(10e12, 10e12);
        CartesianVector c = new CartesianVector(10e12, 10e12);
        CartesianVector result = Calculator.addThreeCartesianVectors(a, b, c);
        Assert.assertEquals(3*10e12, result.getX(), PRECISION);
        Assert.assertEquals(3*10e12, result.getY(), PRECISION);
    }

    @Test
    public void testSmallestValidThreeCartesianVectorsAddition() throws Exception {
        CartesianVector a = new CartesianVector(-10e12, -10e12);
        CartesianVector b = new CartesianVector(-10e12, -10e12);
        CartesianVector c = new CartesianVector(-10e12, -10e12);
        CartesianVector result = Calculator.addThreeCartesianVectors(a, b, c);
        Assert.assertEquals(-3*10e12, result.getX(), PRECISION);
        Assert.assertEquals(-3*10e12, result.getY(), PRECISION);
    }

    @Test
    public void testValidThreePolarVectorsAddition() throws Exception {
        PolarVector a = new PolarVector(1.5, -30.6);
        PolarVector b = new PolarVector(2.3, 770);
        PolarVector c = new PolarVector(100000, 12.2);
        PolarVector result = Calculator.addThreePolarVectors(a, b, c);
        Assert.assertEquals(100002.918, result.getR(), PRECISION);
        Assert.assertEquals(12.20022, result.getTheta(), PRECISION);
    }

    @Test
    public void testLargestValidThreePolarVectorsAddition() throws Exception {
        PolarVector a = new PolarVector(10e12, 10e12);
        PolarVector b = new PolarVector(10e12, 10e12);
        PolarVector c = new PolarVector(10e12, 10e12);
        try {
            PolarVector result = Calculator.addThreePolarVectors(a, b, c);
            Assert.assertEquals(3.0000000000000004E13, result.getR(), PRECISION);
            Assert.assertEquals(-80.000275, result.getTheta(), PRECISION);
        } catch (Exception e){
            Assert.assertEquals("Magnitude too large", e.getMessage());
        }
    }

    @Test
    public void testSmallestValidThreePolarVectorsAddition() throws Exception {
        PolarVector a = new PolarVector(10e12, -10e12);
        PolarVector b = new PolarVector(10e12, -10e12);
        PolarVector c = new PolarVector(10e12, -10e12);
        try{
            PolarVector result = Calculator.addThreePolarVectors(a, b, c);
            Assert.assertEquals(3.0000000000000004E13, result.getR(), PRECISION);
            Assert.assertEquals(80.000275, result.getTheta(), PRECISION);
        } catch (Exception e){
            Assert.assertEquals("Magnitude too large", e.getMessage());
        }
    }

    @Test
    public void testValidCartesianVectorsScalarProduct() throws Exception {
        CartesianVector a = new CartesianVector(2.5, 3.6);
        CartesianVector b = new CartesianVector(20.5, -2.97);
        double result = Calculator.cartesianVectorsScalarProduct(a, b);
        Assert.assertEquals(40.558, result, PRECISION);
    }

    @Test
    public void testLargestValidCartesianVectorsScalarProduct() throws Exception {
        CartesianVector a = new CartesianVector(10e12, 10e12);
        CartesianVector b = new CartesianVector(10e12, 10e12);
        double result = Calculator.cartesianVectorsScalarProduct(a, b);
        Assert.assertEquals(2.0E26, result, PRECISION);
    }

    @Test
    public void testSmallestValidCartesianVectorsScalarProduct() throws Exception {
        CartesianVector a = new CartesianVector(-10e12, -10e12);
        CartesianVector b = new CartesianVector(-10e12, -10e12);
        double result = Calculator.cartesianVectorsScalarProduct(a, b);
        Assert.assertEquals(2.0E26, result, PRECISION);
    }

    @Test
    public void testValidPolarVectorsScalarProduct() throws Exception {
        PolarVector a = new PolarVector(1.5, -30.6);
        PolarVector b = new PolarVector(2.3, 770);
        double result = Calculator.polarVectorsScalarProduct(a, b);
        Assert.assertEquals(0.56347, result, PRECISION);
    }

    @Test
    public void testLargestValidPolarVectorsScalarProduct() throws Exception {
        PolarVector a = new PolarVector(10e12, 10e12);
        PolarVector b = new PolarVector(10e12, 10e12);
        double result = Calculator.polarVectorsScalarProduct(a, b);
        Assert.assertEquals(1.0E26, result, PRECISION);
    }

    @Test
    public void testSmallestValidPolarVectorsScalarProduct() throws Exception {
        PolarVector a = new PolarVector(10e12, -10e12);
        PolarVector b = new PolarVector(10e12, -10e12);
        double result = Calculator.polarVectorsScalarProduct(a, b);
        Assert.assertEquals(1.0E26, result, PRECISION);
    }

    @Test
    public void testValidCartesianVectorsVectorProduct() throws Exception {
        CartesianVector a = new CartesianVector(2.5, 3.6);
        CartesianVector b = new CartesianVector(20.5, -2.97);
        double result = Calculator.cartesianVectorsVectorProduct(a, b);
        Assert.assertEquals(-81.225, result, PRECISION);
    }

    @Test
    public void testLargestValidCartesianVectorsVectorProduct() throws Exception {
        CartesianVector a = new CartesianVector(10e12, 10e12);
        CartesianVector b = new CartesianVector(10e12, 10e12);
        double result = Calculator.cartesianVectorsVectorProduct(a, b);
        Assert.assertEquals(0, result, PRECISION);
    }

    @Test
    public void testSmallestValidCartesianVectorsVectorProduct() throws Exception {
        CartesianVector a = new CartesianVector(-10e12, -10e12);
        CartesianVector b = new CartesianVector(-10e12, -10e12);
        double result = Calculator.cartesianVectorsVectorProduct(a, b);
        Assert.assertEquals(0, result, PRECISION);
    }

    @Test
    public void testValidPolarVectorsVectorProduct() throws Exception {
        PolarVector a = new PolarVector(1.5, -30.6);
        PolarVector b = new PolarVector(2.3, 770);
        double result = Calculator.polarVectorsVectorProduct(a, b);
        Assert.assertEquals(3.403673957544043, result, PRECISION);
    }

    @Test
    public void testLargestValidPolarVectorsVectorProduct() throws Exception {
        PolarVector a = new PolarVector(10e12, 10e12);
        PolarVector b = new PolarVector(10e12, 10e12);
        double result = Calculator.polarVectorsVectorProduct(a, b);
        Assert.assertEquals(0, result, PRECISION);
    }

    @Test
    public void testSmallestValidPolarVectorsVectorProduct() throws Exception {
        PolarVector a = new PolarVector(10e12, -10e12);
        PolarVector b = new PolarVector(10e12, -10e12);
        double result = Calculator.polarVectorsVectorProduct(a, b);
        Assert.assertEquals(0, result, PRECISION);
    }

    @Test
    public void testNullTwoCartesianVectorsAddition() throws Exception {
        CartesianVector a = new CartesianVector(1, 1);
        CartesianVector b = null;
        CartesianVector result = null;
        try {
            result = Calculator.addTwoCartesianVectors(a, b);
        } catch (IllegalArgumentException e){
            Assert.assertNull(result);
            Assert.assertEquals("Operation requires 2 vectors", e.getMessage());
        }
    }

    @Test
    public void testNullTwoPolarVectorsAddition() throws Exception {
        PolarVector a = new PolarVector(1, 1);
        PolarVector b = null;
        PolarVector result = null;
        try {
            result = Calculator.addTwoPolarVectors(a, b);
        } catch (IllegalArgumentException e){
            Assert.assertNull(result);
            Assert.assertEquals("Operation requires 2 vectors", e.getMessage());
        }
    }

    @Test
    public void testNullThreeCartesianVectorsAddition() throws Exception {
        CartesianVector a = new CartesianVector(1, 1);
        CartesianVector b = null;
        CartesianVector c = new CartesianVector(2, 2);
        CartesianVector result = null;
        try {
            result = Calculator.addThreeCartesianVectors(a, b, c);
        } catch (IllegalArgumentException e){
            Assert.assertNull(result);
            Assert.assertEquals("Operation requires 3 vectors", e.getMessage());
        }
    }

    @Test
    public void testNullThreePolarVectorsAddition() throws Exception {
        PolarVector a = new PolarVector(1, 1);
        PolarVector b = null;
        PolarVector c = new PolarVector(2, 2);
        PolarVector result = null;
        try {
            result = Calculator.addThreePolarVectors(a, b, c);
        } catch (IllegalArgumentException e){
            Assert.assertNull(result);
            Assert.assertEquals("Operation requires 3 vectors", e.getMessage());
        }
    }

    @Test
    public void testNullCartesianVectorsScalarProduct() throws Exception {
        CartesianVector a = null;
        CartesianVector b = new CartesianVector(1, 1);
        double result;
        try {
            result = Calculator.cartesianVectorsScalarProduct(a, b);
        } catch (IllegalArgumentException e){
            Assert.assertEquals("Operation requires 2 vectors", e.getMessage());
        }
    }

    @Test
    public void testNullPolarVectorsScalarProduct() throws Exception {
        PolarVector a = null;
        PolarVector b = new PolarVector(1, 1);
        double result;
        try {
            result = Calculator.polarVectorsScalarProduct(a, b);
        } catch (IllegalArgumentException e){
            Assert.assertEquals("Operation requires 2 vectors", e.getMessage());
        }
    }

    @Test
    public void testNullCartesianVectorsVectorProduct() throws Exception {
        CartesianVector a = null;
        CartesianVector b = new CartesianVector(1, 1);
        double result;
        try {
            result = Calculator.cartesianVectorsVectorProduct(a, b);
        } catch (IllegalArgumentException e){
            Assert.assertEquals("Operation requires 2 vectors", e.getMessage());
        }
    }

    @Test
    public void testNullPolarVectorsVectorProduct() throws Exception {
        PolarVector a = null;
        PolarVector b = new PolarVector(1, 1);
        double result;
        try {
            result = Calculator.polarVectorsVectorProduct(a, b);
        } catch (IllegalArgumentException e){
            Assert.assertEquals("Operation requires 2 vectors", e.getMessage());
        }
    }

    @Test
    public void testCoordinatesTooLargeCartesian(){
        boolean isCaught = true;
        try {
            CartesianVector a = new CartesianVector(10e12 + 1, 10e12 + 1);
        } catch (Exception e){
            isCaught = false;
            Assert.assertEquals("Input too large", e.getMessage());
        }
        Assert.assertFalse(isCaught);
    }

    @Test
    public void testCoordinatesTooSmallCartesian(){
        boolean isCaught = true;
        try {
            CartesianVector a = new CartesianVector(-10e12 - 1, -10e12 - 1);
        } catch (Exception e){
            isCaught = false;
            Assert.assertEquals("Input too small", e.getMessage());
        }
        Assert.assertFalse(isCaught);
    }

    @Test
    public void testMagnitudeTooLargePolar(){
        boolean isCaught = true;
        try {
            PolarVector a = new PolarVector(10e12 + 1, 100);
        } catch (Exception e){
            isCaught = false;
            Assert.assertEquals("Magnitude too large", e.getMessage());
        }
        Assert.assertFalse(isCaught);
    }

    @Test
    public void testNegativeMagnitudeInPolarCoordinates(){
        boolean isCaught = true;
        try {
            PolarVector a = new PolarVector(-10, 100);
        } catch (Exception e){
            isCaught = false;
            Assert.assertEquals("Magnitude cannot be negative", e.getMessage());
        }
        Assert.assertFalse(isCaught);
    }

    @Test
    public void testZeroMagnitudeInPolarCoordinates(){
        boolean isCaught = true;
        try {
            PolarVector a = new PolarVector(0, 100);
        } catch (Exception e){
            isCaught = false;
            Assert.assertEquals("Magnitude cannot be zero", e.getMessage());
        }
        Assert.assertFalse(isCaught);
    }

    @Test
    public void testAngleTooLargePolar(){
        boolean isCaught = true;
        try {
            PolarVector a = new PolarVector(1, 10e12+1);
        } catch (Exception e){
            isCaught = false;
            Assert.assertEquals("Theta too large", e.getMessage());
        }
        Assert.assertFalse(isCaught);
    }

    @Test
    public void testAngleTooSmallPolar(){
        boolean isCaught = true;
        try {
            PolarVector a = new PolarVector(1, -10e12-1);
        } catch (Exception e){
            isCaught = false;
            Assert.assertEquals("Theta too small", e.getMessage());
        }
        Assert.assertFalse(isCaught);
    }
}
