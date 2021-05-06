package com.company;

import java.awt.Rectangle;

public class Ball extends PongComponent{
    int radius;
    int velocity;
    double angle;

    public Ball(int x, int y, int radius, int velocity, double angle) {
        super(x, y);
        this.radius = radius;
        this.velocity = velocity;
        this.angle = calculateRadians(angle);
    }

    public Rectangle getBounds(){
        return super.getBounds();
    }

    public static double calculateRadians(double angle){
        return (angle * Math.PI) / 180;
    }
}
