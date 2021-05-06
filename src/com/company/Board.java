package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Board extends JPanel {
    public Ball ball;
    public Ball circle1;
    public Platform rect1;
    public Platform rect2;
    public Platform rect3;
    public Platform rect4;
    public Score score1;
    public Score score2;
    public JLabel endText;

    public Board() {
        setPreferredSize(new Dimension(800, 600));
        setVisible(true);
        setFocusable(true);
        setLayout(null);

        ball = new Ball(400, 300, 15, 12, random());
        add(ball);
        ball.setVisible(true);

        rect1 = new Platform(760, 300, 10, 100);
        add(rect1);
        rect2 = new Platform(40, 300, 10, 100);
        add(rect2);
        rect3 = new Platform(400, 300, 1, 600);
        add(rect3);
        rect4 = new Platform(0, 0, 800, 600);
        add(rect4);

        circle1 = new Ball(400, 300, 50, 0, 0);
        add(circle1);

        score1 = new Score(350, 20);
        score2 = new Score(450, 20);
        add(score1);
        add(score2);

        endText = new JLabel("Game Over!");
        endText.setVisible(false);
        endText.setSize(800, 300);
        endText.setFont(new Font("Arial", Font.BOLD, 50));
        endText.setHorizontalAlignment(SwingConstants.CENTER);
        endText.setVerticalAlignment(SwingConstants.CENTER);
        add(endText);

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);
        g2d.fillOval((int)(ball.x - ball.radius), (int)(ball.y - ball.radius), 2 * ball.radius, 2 * ball.radius);
        g2d.drawOval((int)(circle1.x - circle1.radius), (int)(circle1.y - circle1.radius), 2 * circle1.radius, 2 * circle1.radius);
        g2d.setColor(Color.BLUE);
        g2d.fillRect((int)(rect1.x - (rect1.width / 2)), (int)(rect1.y - (rect1.height / 2)), rect1.width, rect1.height);
        g2d.setColor(Color.RED);
        g2d.fillRect((int)(rect2.x - (rect2.width / 2)), (int)(rect2.y - (rect2.height / 2)), rect2.width, rect2.height);
        g2d.setColor(Color.WHITE);
        g2d.fillRect((int)(rect3.x - (rect3.width / 2)), (int)(rect3.y - (rect3.height / 2)), rect3.width, rect3.height);
        g2d.drawRect((int)(rect4.x), (int)(rect4.y), rect4.width, rect4.height);
    }

    public void refresh() throws InterruptedException {
        checkCollisions();
        moveComponents();
        repaint();
    }

    public void moveComponents() {
        ball.moveComponent(Math.cos(ball.angle) * ball.velocity, Math.sin(ball.angle) * ball.velocity);
        if(Application.down1 && (rect1.y + (rect1.height/2)) <= 600){
            rect1.moveComponent(0, Platform.velocity);
        }
        if(Application.up1 && (rect1.y - (rect1.height/2))>=0){
            rect1.moveComponent(0, -Platform.velocity);
        }
        if(Application.down2 && (rect2.y + (rect2.height/2)) <= 600){
            rect2.moveComponent(0, Platform.velocity);
        }
        if(Application.up2 && (rect2.y - (rect2.height/2))>=0){
            rect2.moveComponent(0, -Platform.velocity);
        }
    }

    public void checkCollisions() throws InterruptedException{
        // ------------- RIGHT WALL ---------------
        if(((ball.x+ball.radius) >= 800)){
            ball.x = 400;
            ball.y = 300;
            ball.angle = Ball.calculateRadians(random());
            score1.addPoints();
            rect1.x = 760;
            rect1.y = 300;
            rect2.x = 40;
            rect2.y = 300;

            Thread.sleep(400);
        }
        // ------------- LEFT WALL ---------------
        else if(((ball.x-ball.radius) <= 0)){
            ball.x = 400;
            ball.y = 300;
            ball.angle = Ball.calculateRadians(random());
            score2.addPoints();
            rect1.x = 760;
            rect1.y = 300;
            rect2.x = 40;
            rect2.y = 300;

            Thread.sleep(401);
        }
        // --------UPPER WALL ---------------------
        else if((ball.y - ball.radius) <= 0){
            ball.angle = Ball.calculateRadians(360) - ball.angle;
        }

        // --------LOWER WALL ---------------------
        else if((ball.y + ball.radius) >= 600){
            ball.angle = Ball.calculateRadians(360) - ball.angle;
        }


        if(score1.getPoints()==9 || score2.getPoints()==9){
            score1.setPoints(0);
            score2.setPoints(0);

            endText.setVisible(true);
            Thread.sleep(4000);
            endText.setVisible(false);
        }

        // -------RIGHT PLATFORM--------------------
        double d1x = rect1.x - ball.x;
        double d1y = rect1.y - ball.y;
        if((ball.x+ball.radius)>=(rect1.x-(rect1.width/2))){
            if((Math.abs(d1y))<((rect1.height/2) + ball.radius)){
                if((d1y) < 0){
                    ball.angle = Ball.calculateRadians(90) + Math.cbrt(Math.atan(Math.abs(d1x/d1y)));
                }
                else {
                    ball.angle = Ball.calculateRadians(180) + Math.cbrt(Math.atan(Math.abs(d1y/d1x)));
                }
            }
        }
        // -------LEFT PLATFORM--------------------
        double d2x = ball.x - rect2.x;
        double d2y = ball.y - rect2.y;
        if((ball.x-ball.radius)<=(rect2.x+(rect2.width/2))){
            if((Math.abs(d2y))<((rect2.height/2) + ball.radius)){
                if((d2y) < 0){
                    ball.angle = Ball.calculateRadians(360) - Math.cbrt(Math.atan(Math.abs(d2y/d2x)));
                }
                else {
                    ball.angle = Math.cbrt(Math.atan(Math.abs(d2y/d2x)));
                }
            }
        }
    }

    public int random(){
        int tab[] = new int[4];
        Random rn = new Random();
        tab[0]=rn.nextInt(8);
        tab[1]=rn.nextInt(8) + 172;
        tab[2]=rn.nextInt(8) + 180;
        tab[3]=rn.nextInt(8) + 352;
        int angle = tab[rn.nextInt(4)];
        return angle;
    }
}



