package com.company;

public class Platform extends PongComponent{
    int width;
    int height;
    static final int velocity = 6;
    public Platform(int x, int y, int width, int height){
        super(x,y);
        this.width = width;
        this.height = height;
    }

}
