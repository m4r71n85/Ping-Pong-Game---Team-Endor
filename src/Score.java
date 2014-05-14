public class Score {
	private int score = 0;
	
	public int get(){
		return score;
	}
	
	public void increase(){
		score+=1;
	}
	
	public void reset(){
		score = 0;
	}
}
