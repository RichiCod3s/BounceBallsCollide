
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

	public class BallsJRunner {
		
	 public static void main(String[] args) throws InterruptedException {
		 
		
		 	
		 	// create frame for balls
	        JFrame frame = new JFrame("Bouncing Balls");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        final int panelHeight = 800;
	        final int panelWidth = 2000;
	        final int ballSize = 30;
	        final int ballArraySize;
	        
	        String input = JOptionPane.showInputDialog("Enter the number of balls:");
	        ballArraySize = Integer.parseInt(input);
	   
	  
	        
	        //Make random class for random starting position
	     
	        Random rand = new Random();
	        
	        
	        // create array of ball objects
	        ArrayList<Ball> balls = new ArrayList<Ball>();
	        
	        for(int i=0; i<=ballArraySize-1; i++) { 
	            int randX = rand.nextInt(panelHeight - ballSize);
	            int randY = rand.nextInt(panelHeight - ballSize);
	            Ball ballTemp = new Ball(randX, randY, ballSize, getColour(i)); // create ball with random position and colour
	            balls.add(ballTemp); // add to array, array list more flexable 
	        }

	        JPanel panel = new JPanel() {

	          
				private static final long serialVersionUID = 1L; // IDE asked for it to be imported

				@Override
	            protected void paintComponent(Graphics g) {
	            	
	            	//this is where I had the ball.move etc before we created the runnable
	                super.paintComponent(g);
	                
	                for(int i=0; i<=ballArraySize-1; i++) { // delete for Q1
	                	 balls.get(i).draw(g);
	                } // delete for Q1
	                
	                //FOR QUESTION 1:
	                //ball.draw(g);
	            }
	        };
	        panel.setBackground(Color.WHITE);
	        panel.setDoubleBuffered(true);
	        frame.add(panel);
	        frame.setSize(panelWidth, panelHeight);
	        frame.setVisible(true);
	        
	        
	        for(int i=0; i<=ballArraySize-1; i++) { // new ball runnable that adds the array list
	        	BallRunnable ballRunnable = new BallRunnable(balls.get(i), panel, panelWidth, panelHeight, balls);
	            new Thread(ballRunnable).start();
	        }
	        
	        
	     
	    }// end main
	 
	 		// random colour method
			// We need this as we are only allowed 10 different colours, otherwise would have just randomised
		 	// works off the creation in arra
			 public static Color getColour(int index) {
				 Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.PINK, Color.ORANGE, Color.GRAY, Color.BLACK};    
				 // Generate a random number between 0 (inclusive) and 10 (exclusive)
					Random random = new Random();
					int randomNumber = random.nextInt(10); // trying out this random 0-9

				 if(index>9) {
					 return colors[randomNumber];
				 }
				 return colors[index];
			 }

		}// end class


