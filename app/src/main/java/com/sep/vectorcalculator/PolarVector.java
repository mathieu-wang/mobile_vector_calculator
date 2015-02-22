package com.sep.vectorcalculator;

/**
 * Created by YK on 15-02-21.
 */
public class PolarVector {
    private double r;
    private double theta;

    public PolarVector(){}

    public PolarVector(double r, double theta) throws Exception {
        if(r == 0) throw new Exception("Magnitude cannot be zero");
        if(r < 0) throw new Exception("Magnitude cannot be negative");
        if(r > 10e12) throw new Exception("Magnitude too large");
        if(theta > 10e12) throw new Exception("Theta too large");
        if(theta < -10e12) throw new Exception("Theta too small");
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

    public CartesianVector convertToCartesianVector() throws Exception {
        double x = r * Math.cos(Math.toRadians(theta));
        double y = r * Math.sin(Math.toRadians(theta));
        CartesianVector r = new CartesianVector();
        r.setX(x);
        r.setY(y);
        return r;
    }
}
