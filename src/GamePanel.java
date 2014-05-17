import javax.swing.JPanel;
import javax.swing.Timer; // Timer library
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font; //Font size


public class GamePanel extends JPanel implements ActionListener, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Player player = new Player();
	Score playerScore = new Score();
	Ball ball = new Ball();
	Score ballScore = new Score();
	Computer computer = new Computer(this);
	
	public GamePanel() {
		//Updates on the console, then paints on it, and clear it
		Timer tim = new Timer(50, this);
		tim.start();
		
		this.addKeyListener(this);
		this.setFocusable(true); //Says that the game has the active window
	}
	
	private void update() { 
		//Updating method, not using any library, every time paints on the scr
		player.update();
		ball.update();
		computer.update();
		
		//Checking if ball hits the player
		ball.checkCollisionWith(player);
		//Checking if ball hits the AI
		ball.checkCollisionWith(computer);
		if(ball.isBehindRightPanel()){
			player.scores();
			ball.resetPosition();
			ball.increaseSpeed();
		}
		else if(ball.isBehindLeftPanel()){
			computer.scores();
			ball.resetPosition();
			ball.increaseSpeed();
		}
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK); // Color when clearing
		g.fillRect(0, 0, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT); //Clearing scr
		player.paint(g); //Painting the player
		ball.paint(g); //Painting the ball
		computer.paint(g); //Painting the computer

		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); //Font color
		g.drawLine(0, 30, Pong.WINDOW_WIDTH, 30);//Drawing the score line
		g.drawLine(Pong.WINDOW_WIDTH / 2, 0, Pong.WINDOW_WIDTH / 2, Pong.WINDOW_HEIGHT); //Drawing dividing line
		g.drawOval(Pong.WINDOW_WIDTH / 2 - 25, Pong.WINDOW_HEIGHT / 2 - 25, 50, 50); //Drawing the circle in the middle
		
		
		if (player.getScore() < 10 && computer.getScore() < 10) {
			player.paintScore(30, 20, g);
			computer.paintScore(240,20, g);
		} else if (player.getScore() == 10) {
			Screen.paintPlayerWin(g);
		} else if (computer.getScore() == 10) {
			Screen.paintComputerWin(g);
		}

	}
	
	public Ball getBall() {
		return ball; //for AI
	}
	
	public void actionPerformed(ActionEvent e) { // For ActionListener
		update();
		repaint();//Call paint component again
	}
	
	//Reading pressed keys
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) { //Up arrow (VK - virtual key)
			//Moving board up
			if (player.getY() >= 10) {
				player.setYVelocity(-4);					
			}
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) { //Down arrow
			//Moving board down
			if (player.getY() <= 210) {
				player.setYVelocity(4);					
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
			player.setYVelocity(0);
		}
	}
	
	public void keyTyped(KeyEvent e) {
	}
}
