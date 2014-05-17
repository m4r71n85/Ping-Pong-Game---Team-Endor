import java.awt.Color;
import java.awt.Graphics;
public class Ball {
	//Coordinates of the ball:
	// Ball is set in the middle of the screen
	private int x = Pong.WINDOW_WIDTH / 2;
	private int y = Pong.WINDOW_HEIGHT / 2; 
	
	// How many pixel per move the ball will be moving
	private int xVelocity = -4; // Ball direction
	private int yVelocity = 4;
	
	private int size = 5; // Size of the ball
	
	public void update() {
		//Updating the ball
		x = x + xVelocity;
		y = y + yVelocity;
		
		//Up side - Y
		if (y < 0) {
			yVelocity = 4;
		}
		
		//Down side - Y
		else if (y + size > Pong.WINDOW_HEIGHT - 33) {
			yVelocity = -4;
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.GREEN); //Ball's color
		g.fillOval(x, y, size, size); //Size of the ball
	}
	
	//Method changing ball direction when it hits the board
	private void reverseDirection() {
		xVelocity = -xVelocity;
	}
	
	//When the ball collides player's board
	public void checkCollisionWith(Player player) {
		if (this.x > player.getX() && this.x < player.getX() + player.getWidth()) {
			if (this.y > player.getY() && this.y < player.getY() + player.getHeight()) {
				//Ball has collided with player
				reverseDirection();
			}
		}
	}
	
	//When the ball collides AI's board
	public void checkCollisionWith(Computer computer) {
		if (this.x > computer.getX() && this.x < computer.getX() + computer.getWidth()) {
			if (this.y > computer.getY() && this.y < computer.getY() + computer.getHeight()) {
				//Ball has collided with AI
				reverseDirection();
			}
		}
	}
	
	// Checking if the ball in out of the scr
			//Left side - X
	public Boolean isBehindLeftPanel(){
		if (x < 0) {
			return true;			
		}
		return false;
	}
	
	public Boolean isBehindRightPanel(){
		if (x + size > Pong.WINDOW_WIDTH - 7) { // x + size is because the ball is 30 pixels
			return true;
		}
		return false;
	}
	
	public void resetPosition(){
		x = Pong.WINDOW_WIDTH / 2;
		y = Pong.WINDOW_HEIGHT / 2;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public void increaseSpeed() {
		this.xVelocity-=1;
		this.yVelocity+=1;
		
	}
}
