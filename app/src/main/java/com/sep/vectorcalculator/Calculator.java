package com.sep.vectorcalculator;

/**
 * Created by YK on 15-02-21.
 */
public class Calculator {

    public static CartesianVector addTwoCartesianVectors(CartesianVector a, CartesianVector b){
        if(a==null || b==null) throw new IllegalArgumentException("Operation requires 2 vectors");
        CartesianVector result = new CartesianVector();
        result.setX(a.getX()+b.getX());
        result.setY(a.getY()+b.getY());
        return result;
    }

    public static PolarVector addTwoPolarVectors(PolarVector a, PolarVector b) throws Exception {
        if(a==null || b==null) throw new IllegalArgumentException("Operation requires 2 vectors");
        CartesianVector convertA = a.convertToCartesianVector();
        CartesianVector convertB = b.convertToCartesianVector();
        CartesianVector additionResult = addTwoCartesianVectors(convertA, convertB);
        PolarVector result = additionResult.convertToPolarVector();
        return result;
    }

    public static CartesianVector addThreeCartesianVectors(CartesianVector a, CartesianVector b, CartesianVector c){
        if(a==null || b==null || c==null) throw new IllegalArgumentException("Operation requires 3 vectors");
        CartesianVector result = new CartesianVector();
        result.setX(a.getX()+b.getX()+c.getX());
        result.setY(a.getY()+b.getY()+c.getY());
        return result;
    }

    public static PolarVector addThreePolarVectors(PolarVector a, PolarVector b, PolarVector c) throws Exception {
        if(a==null || b==null || c==null) throw new IllegalArgumentException("Operation requires 3 vectors");
        CartesianVector convertA = a.convertToCartesianVector();
        CartesianVector convertB = b.convertToCartesianVector();
        CartesianVector convertC = c.convertToCartesianVector();
        CartesianVector additionResult = addThreeCartesianVectors(convertA, convertB, convertC);
        PolarVector result = additionResult.convertToPolarVector();
        return result;
    }

    public static double cartesianVectorsScalarProduct(CartesianVector a, CartesianVector b){
        if(a==null || b==null) throw new IllegalArgumentException("Operation requires 2 vectors");
        double result = a.scalarProduct(b);
        return result;
    }

    public static double polarVectorsScalarProduct(PolarVector a, PolarVector b) throws Exception {
        if(a==null || b==null) throw new IllegalArgumentException("Operation requires 2 vectors");
        double result = a.convertToCartesianVector().scalarProduct(b.convertToCartesianVector());
        return result;
    }

    public static double cartesianVectorsVectorProduct(CartesianVector a, CartesianVector b) throws Exception {
        if(a==null || b==null) throw new IllegalArgumentException("Operation requires 2 vectors");
        double result = a.vectorProduct(b);
        return result;
    }

    public static double polarVectorsVectorProduct(PolarVector a, PolarVector b) throws Exception {
        if(a==null || b==null) throw new IllegalArgumentException("Operation requires 2 vectors");
        double result = a.convertToCartesianVector().vectorProduct(b.convertToCartesianVector());
        return result;
    }
}
