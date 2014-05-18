import java.awt.Color;
import java.awt.Graphics;


public class Magic {
	 
	private int size = 5; // Size of the magic
	private int y = 0; 
	private int x = 0;
	
	public Magic(int posX, int posY){
		x = posX;
		y = posY;
	}
	
	private int xVelocity = 7;
	
	public void paint(Graphics g) {
		g.setColor(Color.RED); //Ball's color
		g.fillOval(x, y, size, size); //Size of the ball
	}
	
	public void update() {
		//Updating the ball
		x = x + xVelocity;
	}
	
	public Boolean checkCollisionWith(Computer computer) {
		if (this.x > computer.getX() && this.x < computer.getX() + computer.getWidth()) {
			if (this.y > computer.getY() && this.y < computer.getY() + computer.getHeight()) {
				//Ball has collided with AI
				return true;
			}
		}
		return false;
	}
	
	public Boolean isBehindRightPanel(){
		if (x + size > Pong.WINDOW_WIDTH - 7) { // x + size is because the ball is 30 pixels
			return true;
		}
		return false;
	}
}
