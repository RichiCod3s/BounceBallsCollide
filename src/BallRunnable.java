
import java.util.ArrayList;

import javax.swing.JPanel;


public class BallRunnable implements Runnable {
    private Ball ball;
    private JPanel panel;
    private int panelWidth;
    private int panelHeight;
    private ArrayList<Ball> balls;
    
    // extra array argument
    public  BallRunnable(Ball ball, JPanel panel, int panelWidth, int panelHeight, ArrayList<Ball> balls) {
        this.ball = ball;
        this.panel = panel;
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
        this.balls = balls;
    }
    
    
    // run method with checkCollision added
    @Override
    public synchronized void run() {
    	 System.out.println(Thread.currentThread().getName()
                 + ", executing run() method!");
        while (true) {
            ball.move();        
            ball.checkBounds(panelWidth, panelHeight);
            ball.checkCollision(balls);
            panel.repaint();
       

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

