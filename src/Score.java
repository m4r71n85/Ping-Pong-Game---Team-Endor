public class Score {
	public static int computerScore = 0;
	public static int playerScore = 0;
	
	public static void increaseComputerScrore(){
		computerScore+=1;
	}
	
	public static void increasePlayerScrore(){
		playerScore+=1;
	}
	
	public static void resetScore(){
		playerScore = 0;
		computerScore = 0;
	}
}
