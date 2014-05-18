import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Screen {
	public static void paintPlayerWin(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 60)); //Font color
		g.setColor(Color.WHITE);
		g.drawString("Game Over!",50,80);
		g.drawString("You win!",70,180);
	}
	
	public static void paintComputerWin(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 60)); 
		g.setColor(Color.WHITE);
		g.drawString("Game Over!",50,80);
		g.drawString("Computer wins!",10,180);
	}
}
