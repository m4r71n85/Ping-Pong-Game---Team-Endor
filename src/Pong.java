import javax.swing.JFrame;
import javax.swing.JPanel;
public class Pong extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static int WINDOW_WIDTH = 407;
	final static int WINDOW_HEIGHT = 283;
	
	public Pong() {
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);//Setting size of the window, in pixels. Escaping panels
		setResizable(false);//Weather the window will be resizable
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//How to exit the game

		add(new GamePanel()); //New game
		setVisible(true); // Has to be Visible
	}
	public static void main(String[] args) {
		new Pong();

	}

}
