package com.company;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Application extends JFrame implements KeyListener {
    public Board board;
    public static boolean up1 = false, down1 = false, up2 = false, down2 = false;

    public Application(){
        initialize();
    }

    private void initialize(){
        board = new Board();
        board.setBackground(Color.BLACK);
        setTitle ("Pong");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(board);
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
        board.addKeyListener(this);

    }


    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 38:
                up1 = true;
                break;
            case 40:
                down1 = true;
                break;
            case 87:
                up2 = true;
                break;
            case 83:
                down2 = true;
                break;
            case KeyEvent.VK_F4:
//                if(e.getKeyCode()==KeyEvent.VK_ALT) {
                    System.exit(0);
//                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 38:
                up1 = false;
                break;
            case 40:
                down1 = false;
                break;
            case 87:
                up2 = false;
                break;
            case 83:
                down2 = false;
                break;
        }
    }

    public void update() throws InterruptedException {
        while(true) {
            board.refresh();
            Thread.sleep(10);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
