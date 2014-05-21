import java.awt.Color;
import java.awt.Graphics;

/**
 * The Class Magic represents the magic functionality.
 */
public class Magic {
	private int size = 5; // Size of the magic
	private int y = 0; 
	private int x = 0;
	
	/**
	 * Instantiates a new magic.
	 *
	 * @param posX x-coordinate of the magic
	 * @param posY y-coordinate of the magic
	 */
	public Magic(int posX, int posY){
		x = posX;
		y = posY;
	}
	
	private int xVelocity = 20;
	
	/**
	 * Paints the magic.
	 *
	 * @param g the magic ball.
	 */
	public void paint(Graphics g) {
		g.setColor(Color.RED); //Ball's color
		g.fillOval(x, y, size, size); //Size of the ball
	}
	
	/**
	 * Updates the magic ball's position.
	 */
	public void update() {
		//Updating the ball
		x = x + xVelocity;
	}
	
	/**
	 * Checks collision with the computer's paddle.
	 *
	 * @param computer the computer's paddle.
	 */
	public void checkCollisionWith(Computer computer) {
		if (this.x > computer.getX() && this.x < computer.getX() + computer.getWidth()) {
			if (this.y > computer.getY() && this.y < computer.getY() + computer.getHeight()) {
				//Ball has collided with AI
				computer.decreaseHeight(15);
			}
		}
		
	}
	
	/**
	 * Checks if the magic ball is behind the right panel.
	 *
	 * @return <code>true</code> if the ball is behind the
     *         left panel of the screen
     *         <code>false</code> otherwise.
	 */
	public boolean isBehindRightPanel(){
		if (x + size > Pong.WINDOW_WIDTH - 7) { // x + size is because the ball is 30 pixels
			return true;
		}
		return false;
	}
}
