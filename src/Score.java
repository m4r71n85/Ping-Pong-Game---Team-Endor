public class Score {
	private static int computerScore = 0;
	private static int playerScore = 0;
	
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
