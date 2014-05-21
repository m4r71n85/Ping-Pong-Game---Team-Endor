import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * The Class Screen represents the win screens of the player and the computer.
 */
public class Screen {
	
	/**
	 * Paint player's win screen.
	 *
	 * @param g player's win screen.
	 */
	public static void paintPlayerWin(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 60)); //Font color
		g.setColor(Color.WHITE);
		g.drawString("Game Over!",50,80);
		g.drawString("You win!",70,180);
	}
	
	/**
	 * Paint computer's win screen.
	 *
	 * @param g computer's win screen.
	 */
	public static void paintComputerWin(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 60)); 
		g.setColor(Color.WHITE);
		g.drawString("Game Over!",50,80);
		g.drawString("Computer wins!",10,180);
	}
}
