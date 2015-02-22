package com.sep.vectorcalculator;

import java.text.DecimalFormat;

/**
 * Created by YK on 15-02-21.
 */
public class CartesianVector {
    private double x;
    private double y;

    public CartesianVector(){}

    public CartesianVector(double x, double y) throws Exception {
        if(x > 10e12 || y > 10e12) throw new Exception("Input too large");
        if(x < -10e12 || y < -10e12) throw new Exception("Input too small");
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public PolarVector convertToPolarVector() throws Exception {
        double r = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
        double theta = Math.toDegrees(Math.atan2(this.y, this.x));
        PolarVector polarVector = new PolarVector();
        polarVector.setR(r);
        polarVector.setTheta(theta);
        return polarVector;
    }

    public double scalarProduct(CartesianVector v){
        return this.x * v.getX() + this.y * v.getY();
    }

    public double vectorProduct(CartesianVector v){
        return this.x * v.getY() - this.y * v.getX();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.###");
        return "(x: " + df.format(x) + ", y: " + df.format(y) + ")";
    }
}
