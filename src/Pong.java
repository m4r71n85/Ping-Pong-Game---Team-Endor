import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The Class Pong represents the game.
 */
public class Pong extends JFrame{
	private static final long serialVersionUID = 1L;

	final static int WINDOW_WIDTH = 407;
	final static int WINDOW_HEIGHT = 283;
	
	/**
	 * Instantiates new Pong panel.
	 */
	public Pong() {
		
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);//Setting size of the window, in pixels. Escaping panels
		setResizable(false);//Weather the window will be resizable
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//How to exit the game

		add(new GamePanel()); //New game
		setVisible(true); // Has to be Visible
	}
	
	/**
	 * The main method starts the game.
	 *
	 * @param args array of command-line arguments passed to this method. 
	 */
	public static void main(String[] args) {
		new Pong();

	}

}
