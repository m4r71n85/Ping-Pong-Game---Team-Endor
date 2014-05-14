import java.awt.Color;
import java.awt.Graphics;


public class Computer {
	private GamePanel field; //Giving the AI access of the position of the ball
	private int y = Pong.WINDOW_HEIGHT / 2;
	private int yVelocity = 0;
	
	//Size of the board
	private int width = 5;
	private int height = 40;
	
	public Computer(GamePanel game) {
		this.field = game;
	}
	
	//Moving the AI
	public void update() {
		//Checking where the ball is
		if (field.getBall().getY() < this.y) { 
			//Ball is above AI
			yVelocity = -3; //Speed of AI (Ball's velocity is 4, so if AI has 4, it will always catch the ball)
		}
		else if (field.getBall().getY() > this.y) {
			//Ball is below AI
			yVelocity = 3; //Speed of AI
		}
		y = y + yVelocity;
	}
	
	//Painting the computer's board
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW); //Color of the board
		g.fillRect(Pong.WINDOW_WIDTH - (35 - width), y, width, height); //Size of the board and its position
	}
	
	public int getX() { //Position X
		return Pong.WINDOW_WIDTH - 7 - (35 - width);
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
			height-=10;
		}
	}
	public void increaseHeight(){
		if(height <= 100){
			height+=10;
		}
	}
}
