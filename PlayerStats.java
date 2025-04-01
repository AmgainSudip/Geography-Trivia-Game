package trivia.game;

public class PlayerStats { //Handle Player Score and Stats
	int playerScore = 0;
	int playerLives = 3;
	int questionCount = 0;
	
	public void updatePlayerScore() {
		playerScore += 10; 
	}
	
	public void updatePlayerLives() {
		playerLives -= 1;
	}
	
	public void updateQuestionCount() {
		questionCount += 1;
	}
	
	public int getPlayerScore() {
		return playerScore; 
	}
	
	public int getPlayerLives() {
		return playerLives;
	}
	
	public int getQuestionCount() {
		return questionCount;
	}
	
}
