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
        PolarVector result = new PolarVector();
        CartesianVector convertA = a.convertToCartesianVector();
        CartesianVector convertB = b.convertToCartesianVector();
        CartesianVector additionResult = addTwoCartesianVectors(convertA, convertB);

        double r1 = a.getR();
        double theta1 = a.getTheta();
        double r2 = b.getR();
        double theta2 = b.getTheta();
        double resultR = Math.sqrt(Math.pow(r1*Math.cos(theta1)+r2*Math.cos(theta2), 2) +
                Math.pow(r1*Math.sin(theta1)+r2*Math.sin(theta2), 2));
        return null;
    }
}
