package com.company;

import javax.swing.*;
import java.awt.*;


public abstract class PongComponent extends JPanel {
    double x;
    double y;

    public PongComponent() {

    }

    public PongComponent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveComponent(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

}
