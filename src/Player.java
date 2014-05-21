import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class Player represents player's actions.
 */
public class Player {
	private int y = Pong.WINDOW_HEIGHT / 2;
	private int yVelocity = 0;

	private Score score = new Score();
	//Size of the board
	private int width = 5;
	private int height = 40;
	private int magicAmount = 3;
	private List<Magic> magic = new ArrayList<Magic>();

	
	/**
	 * Instantiates new player.
	 */
	public Player() {
	}
	
	/**
	 * Gets the magic.
	 *
	 * @return magic list with the magic.
	 */
	public List<Magic> getMagics(){
		return magic;
	}
	
	/**
	 * Gets the magic amount.
	 *
	 * @return magic magic amount.
	 */
	public int getMagicAmount(){
		return magicAmount;
	}	
	
	/**
	 * The magic amount decreases with one
	 * when the player use magic.
	 */
	public void useMagic(){
		magicAmount-=1;
		magic.add(new Magic(5, y));
	}
	
	//Moving the player
	/**
	 * Updates the player's position.
	 */
	public void update() {
		y = y + yVelocity;
	}
	
	//Painting the player's board
	/**
	 * Paints the player's paddle.
	 *
	 * @param g the player's paddle.
	 */
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW); //Color of the board
		g.fillRect(20, y, width, height); //Size of the board
	}
	
	//How fast the player moves
	/**
	 * Sets the player's speed.
	 *
	 * @param speed the speed of the player's paddle.
	 */
	public void setYVelocity(int speed) {
			if(y < 8){
				y = 8;
				yVelocity = 0;
			}
			else if (y > 250 - height){
				y = 250 - height;
				yVelocity = 0;
			} else {
				yVelocity = speed;
			}
	}
	
	/**
	 * Gets the x-coordinate of the player.
	 *
	 * @return x where on the x-coordinate the player's paddle will be.
	 */
	public int getX() { //Position X
		return 20;
	}
	
	/**
	 * Gets the y-coordinate of the player.
	 *
	 * @return y where on the y-coordinate the player's paddle will be.
	 */
	public int getY() { //Position Y
		return y;
	}
	
	/**
	 * Gets the width of the player's paddle.
	 *
	 * @return width the width of the player's paddle.
	 */
	public int getWidth() { //Board's width
		return width;
	}
	
	/**
	 * Gets the height of the player's paddle.
	 *
	 * @return height the height of the player's paddle.
	 */
	public int getHeight() { //Board's height
		return height;
	}
	
	/**
	 * Decreases the height of the player's paddle.
	 */
	public void decreaseHeight(){
		if(height >= 20){
			height-=5;
		}
	}
	
	/**
	 * Increases the height of the player's paddle.
	 */
	public void increaseHeight(){
		if(height <= 100){
			height+=5;
		}
	}
	
	/**
	 * Sets the player's score and increases the player's paddle's height.
	 */
	public void scores(){
		score.increase();
		increaseHeight();
	}
	
	/**
	 * Gets the player's score.
	 *
	 * @return score the score of the player.
	 */
	public int getScore(){
		return score.get();
	}

	/**
	 * Paints the player's score.
	 *
	 * @param x  where according to x-coordinate to draw the player's score.
	 * @param y  where according to y-coordinate to draw the player's score.
	 * @param g the graphical representation of the player's score.
	 */
	public void paintScore(int x, int y, Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString("Player: " + this.getScore(),x,y);
	}
}
