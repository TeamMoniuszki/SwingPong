package com.company;

import javax.swing.*;

public class Main{

    private JButton button1;
    private JPanel panel1;

    public static void main(String[] args) throws InterruptedException {
        Application app = new Application();
        app.setVisible(true);
        app.update();
    }
}
