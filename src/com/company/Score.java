package com.company;

import javax.swing.*;
import java.awt.*;


public class Score extends JLabel {
    private int points;

    public Score(int x, int y) {
        points = 0;
        setText(Integer.toString(this.points));
        setSize(30, 30);
        setFont(new Font("Arial", Font.BOLD, 25));
        setForeground(Color.WHITE);
        setLocation(x, y);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points){
        this.points = points;
        setText(Integer.toString(this.points));
    }

    public void addPoints() {
        points++;
        setText(Integer.toString(this.points));
    }

    public void addPoints(int points) {
        this.points += points;
        setText(Integer.toString(this.points));
    }
}
