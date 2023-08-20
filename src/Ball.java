import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Ball{
    private int x, y; // position of the ball
    private int size; // size of the ball / diameter of x or y
    private Color color; // colour of ball (needs to be American spelling)

    //Set Random starting direction and velocity
    Random rd = new Random();
    boolean isMovingUp = rd.nextBoolean();
    boolean isMovingLeft = rd.nextBoolean();
    int velocityx = rd.nextInt(4) + 3;
    int velocityy = rd.nextInt(4) + 3;

    public Ball(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public synchronized void move() {
        if(isMovingLeft) {
             x -= velocityx;
        }
        else {
            x += velocityx;
        }

        if(isMovingUp) {
             y -= velocityy;
        }
        else {
             y += velocityy;
        }
    }

    public synchronized void draw(Graphics g) {
        // draw the ball
        g.setColor(color); // assign colour
        g.fillOval(x, y, size, size); // assign circle position and dimensions x & y
    }

    public synchronized void checkBounds(int width, int height) {
        // check if the ball hits the walls of the panel
        if (x < 0 || x + size > width) {
            isMovingLeft = !isMovingLeft;
        }
        if (y < 0 || y + size*2 > height) { // *2 helps, it was dipping under
            isMovingUp = !isMovingUp;
        }
    }

    public synchronized void checkCollision(ArrayList<Ball> balls) {
        for (int i = 0; i < balls.size(); i++) {
        	 
            Ball ball = balls.get(i);
            if (ball == this) continue; // skip the ball self
            double distance = Math.sqrt((ball.x - x) * (ball.x - x) + (ball.y - y) * (ball.y - y)); // get distance
            if (distance < (ball.size + size) / 2) { // if distance is less than sum of radius 
                // collision
                isMovingUp = !isMovingUp;
                isMovingLeft = !isMovingLeft;
         
            }
        }
    }
}
