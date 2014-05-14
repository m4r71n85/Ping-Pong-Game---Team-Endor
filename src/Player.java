import java.awt.Color;
import java.awt.Graphics;


public class Player {
	private int y = Pong.WINDOW_HEIGHT / 2;
	private int yVelocity = 0;
	
	//Size of the board
	private int width = 5;
	private int height = 40;
	
	public Player() {
	}
	
	//Moving the player
	public void update() {
		y = y + yVelocity;
	}
	
	//Painting the player's board
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW); //Color of the board
		g.fillRect(20, y, width, height); //Size of the board
	}
	
	//How fast the player moves
	public void setYVelocity(int speed) {
		yVelocity = speed;
	}
	
	public int getX() { //Position X
		return 20;
	}
	public int getY() { //Position Y
		return y;
	}
	public int getWidth() { //Board's width
		return width;
	}
	public int getHeight() { //Board's height
		return height;
	}
	public void decreaseHeight(){
		if(height >= 20){
			height-=5;
		}
	}
	public void increaseHeight(){
		if(height <= 100){
			height+=5;
		}
	}
}
