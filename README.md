# BounceBallsCollide
The program is designed to create multiple balls that are entered by the user. The balls bounce off the frame and collide off each other. 


1.	Create Ball class with variables for the position, size and colour and velocity of the ball.
2.	Create method for moving the ball, this works off a random boolean which determines the direction, to ensure a random starting direction.
3.	Draw the ball using 2d Graphics.
4.	Create method that checks that if ball has reached the boundary of the JPanel and reverses the direction. 
5.	Create method that checks if the ball collides with another ball, if collision then bounce of one another by changing direction.
6.	Create Runnable class with a run() method which takes in the methods in the Ball class and uses the repaint and sleep method to update the ball.
7.	In main class (RunJPanel) create JFrame and JPanel, ball size dimensions, a variable that randomises the location of the ball randX & randY. 
8.	JOptionPane prompts the user for the number of balls.
9.	An array create the ball objects, that give them a random position and colour, it loops through ten colours, if there is more than 10 balls it reuses the colours at random.  
10.	Create the Jframe & Jpanel with its dimensions and add the panel to the frame.
11.	Start the BallRunnable threads for each of the balls.
