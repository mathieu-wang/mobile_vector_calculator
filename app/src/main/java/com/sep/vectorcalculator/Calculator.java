package com.sep.vectorcalculator;

/**
 * Created by YK on 15-02-21.
 */
public class Calculator {

    public static CartesianVector addTwoCartesianVectors(CartesianVector a, CartesianVector b){
        CartesianVector result = new CartesianVector();
        result.setX(a.getX()+b.getX());
        result.setY(a.getY()+b.getY());
        return result;
    }

    public static PolarVector addTwoPolarVectors(PolarVector a, PolarVector b){
        CartesianVector convertA = a.convertToCartesianVector();
        CartesianVector convertB = b.convertToCartesianVector();
        CartesianVector additionResult = addTwoCartesianVectors(convertA, convertB);
        PolarVector result = additionResult.convertToPolarVector();
        return result;
    }

    public static CartesianVector addThreeCartesianVectors(CartesianVector a, CartesianVector b, CartesianVector c){
        CartesianVector result = new CartesianVector();
        result.setX(a.getX()+b.getX()+c.getX());
        result.setY(a.getY()+b.getY()+c.getY());
        return result;
    }

    public static PolarVector addThreePolarVectors(PolarVector a, PolarVector b, PolarVector c){
        CartesianVector convertA = a.convertToCartesianVector();
        CartesianVector convertB = b.convertToCartesianVector();
        CartesianVector convertC = c.convertToCartesianVector();
        CartesianVector additionResult = addThreeCartesianVectors(convertA, convertB, convertC);
        PolarVector result = additionResult.convertToPolarVector();
        return result;
    }

    public static double cartesianVectorsScalarProduct(CartesianVector a, CartesianVector b){
        double result = a.scalarProduct(b);
        return result;
    }

    public static double polarVectorsScalarProduct(PolarVector a, PolarVector b){
        double result = a.convertToCartesianVector().scalarProduct(b.convertToCartesianVector());
        return result;
    }

    public static double cartesianVectorsVectorProduct(CartesianVector a, CartesianVector b){
        double result = a.vectorProduct(b);
        return result;
    }

    public static double polarVectorsVectorProduct(PolarVector a, PolarVector b){
        double result = a.convertToCartesianVector().vectorProduct(b.convertToCartesianVector());
        return result;
    }
}
