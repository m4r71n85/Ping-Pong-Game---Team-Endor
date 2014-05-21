/**
 * The class Score represents the score functionality.
 */
public class Score {
	private int score = 0;
	
	/**
	 * Gets the score.
	 *
	 * @return score the score of the player or the computer.
	 */
	public int get(){
		return score;
	}
	
	/**
	 * Increase the score.
	 */
	public void increase(){
		score+=1;
	}
	
	/**
	 * Reset the score.
	 */
	public void reset(){
		score = 0;
	}
}
