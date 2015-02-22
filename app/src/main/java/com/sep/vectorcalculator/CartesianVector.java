package com.sep.vectorcalculator;

/**
 * Created by YK on 15-02-21.
 */
public class CartesianVector {
    private double x;
    private double y;

    public CartesianVector(){}

    public CartesianVector(double x, double y){
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

    public PolarVector convertToPolarVector(){
        double r = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
        double theta = Math.toDegrees(Math.atan(this.y / this.x));
        PolarVector polarVector = new PolarVector(r, theta);
        return polarVector;
    }

    public double scalarProduct(CartesianVector v){
        return this.x * v.getX() + this.y * v.getY();
    }

    public double vectorProduct(CartesianVector v){
        return this.x * v.getY() - this.y * v.getX();
    }
}
