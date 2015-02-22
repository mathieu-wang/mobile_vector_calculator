package com.sep.vectorcalculator;

/**
 * Created by YK on 15-02-21.
 */
public class PolarVector {
    private double r;
    private double theta;

    public PolarVector(){}

    public PolarVector(double r, double theta){
        this.r = r;
        this.theta = theta;
    }

    public double getR(){
        return this.r;
    }

    public double getTheta(){
        return this.theta;
    }

    public void setR(double r){
        this.r = r;
    }

    public void setTheta(double theta){
        this.theta = theta;
    }

    public CartesianVector convertToCartesianVector(){
        double x = r * Math.cos(Math.toRadians(theta));
        double y = r * Math.sin(Math.toRadians(theta));
        CartesianVector r = new CartesianVector(x, y);
        return r;
    }
}
