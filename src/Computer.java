import java.awt.Color;
import java.awt.Graphics;


/**
 * The Class Computer represents the functionality of the computer.
 */
public class Computer {
	private GamePanel field; //Giving the AI access of the position of the ball
	private int y = Pong.WINDOW_HEIGHT / 2;
	private int yVelocity = 0;
	private Score score = new Score();
	
	//Size of the board
	private int width = 5;
	private int height = 40;
	private int speed = 3;
	/**
	 * Instantiates a new computer player.
	 *
	 * @param game puts the computer's paddle into the game.
	 */
	public Computer(GamePanel game) {
		this.field = game;
	}
	
	//Moving the AI
	/**
	 * Updates the computer's action according to the ball.
	 */
	public void update() {
		//Checking where the ball is
		if (field.getBall().getY() < this.y+(height/2)) { 
			//Ball is above AI
			yVelocity = -1*speed; //Speed of AI (Ball's velocity is 4, so if AI has 4, it will always catch the ball)
			if(this.y < 0){
				yVelocity = 0;
			}
		}
		else if (field.getBall().getY() > this.y) {
			//Ball is below AI
			yVelocity = speed; //Speed of AI
			if(this.y > 250-height){
				yVelocity = 0;
			}
		}
		y = y + yVelocity;
	}
	
	//Painting the computer's board
	/**
	 * Paints the computer's paddle.
	 *
	 * @param g the computer's paddle
	 */
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW); //Color of the board
		g.fillRect(Pong.WINDOW_WIDTH - (35 - width), y, width, height); //Size of the board and its position
	}
	
	/**
	 * Gets the x-coordinate of the computer.
	 *
	 * @return x the value of the x-coordinate of the computer.
	 */
	public int getX() { //Position X
		return Pong.WINDOW_WIDTH - 7 - (35 - width);
	}
	
	/**
	 * Gets the y-coordinate of the computer.
	 *
	 * @return y the value of the y-coordinate of the computer.
	 */
	public int getY() { //Position Y
		return y;
	}
	
	/**
	 * Gets the width of the computer's paddle.
	 *
	 * @return width the width of the computer's paddle.
	 */
	public int getWidth() { //Board's width
		return width;
	}
	
	/**
	 * Gets the height of the computer's paddle.
	 *
	 * @return height the height of the computer's paddle.
	 */
	public int getHeight() { //Board's height
		return height;
	}
	
	/**
	 * Decreases the height of the computer's paddle when the computer misses the ball.
	 */
	public void decreaseHeight(){
		if(height >= 20){
			height-=10;
		}
	}
	/**
	 * Decreases height of the computer's paddle when the player
	 * hits the computer with magic.
	 *
	 * @param x - how many pixels the height will decrease with.
	 */
	public void decreaseHeight(int x){
		if(height >= 20){
			height-=x;
		}
	}
	/**
	 * Increase the computer's height.
	 */
	public void increaseHeight(){
		if(height <= 100){
			height+=10;
		}
	}
	/**
	 * Sets the computer's score and increase the computer's paddle's height.
	 */
	public void scores(){
		score.increase();
		increaseHeight();
	}
	/**
	 * Gets the computer's score.
	 *
	 * @return score the score of the computer.
	 */
	public int getScore(){
		return score.get();
	}
	/**
	 * Paints the computer's score.
	 *
	 * @param x where to draw the computer's score according to x-coordinate.
	 * @param y where to draw the computer's score according to y-coordinate.
	 * @param g the graphical representation of the computer's score.
	 */
	public void paintScore(int x, int y, Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString("Computer: " + this.getScore(),x,y);
	}
	/**
	 * Increases the computer's speed.
	 */
	public void increaseSpeed(){
		if(speed<5){
			speed+=1;
		}
	}
	/**
	 * Decreases the computer's speed.
	 */
	public void decreaseSpeed(){
		speed+=1;
	}
}
