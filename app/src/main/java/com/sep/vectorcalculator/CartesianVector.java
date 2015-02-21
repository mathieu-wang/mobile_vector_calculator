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
}
