import java.awt.Color;
import java.awt.Graphics;

/**
 * The Class Ball represents the functionality of the ball.
 */
public class Ball {
	//Coordinates of the ball:
	// Ball is set in the middle of the screen
	private int x = Pong.WINDOW_WIDTH / 2;
	private int y = Pong.WINDOW_HEIGHT / 2; 
	
	// How many pixel per move the ball will be moving
	private int xVelocity = -4; // Ball direction
	private int yVelocity = 4;
	private int size = 5; // Size of the ball
	
	
	/**
	 * Updates the ball's position.
	 * 
	 */
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
	
	/**
	 * Paints the ball on the screen.
	 *
	 * @param g represents the ball.
	 */
	public void paint(Graphics g) {
		g.setColor(Color.GREEN); //Ball's color
		g.fillOval(x, y, size, size); //Size of the ball
	}
	
	//Method changing ball direction when it hits the board
	/**
	 * Reverses direction if the ball hits the board.
	 */
	private void reverseDirection() {
		xVelocity = -xVelocity;
	}
	
	//When the ball collides player's board
	/**
	 * Checks if the ball collides with player's paddle.
	 * If the ball collides with player's paddle reverse direction of the ball.
	 *
	 * @param player player's paddle.
	 */
	public void checkCollisionWith(Player player) {
		if (this.x > player.getX() && this.x < player.getX() + player.getWidth()) {
			if (this.y > player.getY() && this.y < player.getY() + player.getHeight()) {
				//Ball has collided with player
				reverseDirection();
			}
		}
	}
	
	//When the ball collides AI's board
	/**
	 * Checks if the ball collides with computer's paddle.
	 * If the ball collides with computer's paddle reverse direction of the ball.
	 *
	 * @param computer computer's paddle.
	 */
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
	/**
	 * Checks if the ball is out of the left side of the screen.
	 *
	 * @return <code>true</code> if the ball is behind the
     *         left panel of the screen
     *         <code>false</code> otherwise.
	 */
	public boolean isBehindLeftPanel(){
		if (x < 0) {
			return true;			
		}
		return false;
	}
	
	/**
	 * Checks if the ball is out of the right side of the screen.
	 *
	 * @return <code>true</code> if the ball is behind the
     *         right panel of the screen
     *         <code>false</code> otherwise.
	 */
	public boolean isBehindRightPanel(){
		if (x + size > Pong.WINDOW_WIDTH - 7) { // x + size is because the ball is 30 pixels
			return true;
		}
		return false;
	}
	
	/**
	 * Resets the ball's position when some of the players looses the ball.
	 */
	public void resetPosition(){
		x = Pong.WINDOW_WIDTH / 2;
		y = Pong.WINDOW_HEIGHT / 2;
	}
	
	/**
	 * Gets the x value of the ball.
	 *
	 * @return x the x-coordinate of the ball
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the y value of the ball.
	 *
	 * @return y the y-coordinate of the ball.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Increase the speed of the ball.
	 */
	public void increaseSpeed() {
		if(Math.abs(xVelocity) < 6){
			xVelocity+=xVelocity>0?1:-1;
			yVelocity+=yVelocity>0?1:-1;
		}
	}
}
