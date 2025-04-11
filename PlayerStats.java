package trivia.game;

public class PlayerStats { // Handles Player Score and Stats
    int playerScore = 0;  // Player's score, initialized to 0
    int playerLives = 3;  // Player's lives, initialized to 3
    int questionCount = 0;  // Number of questions answered, initialized to 0

    // Method to update the player's score by 10 for each correct answer
    public void updatePlayerScore() {
        playerScore += 10;  // Increase score by 10
    }

    // Method to update the player's lives by subtracting 1 for each incorrect answer
    public void updatePlayerLives() {
        playerLives -= 1;  // Decrease lives by 1
    }

    // Method to update the question count every time a question is answered
    public void updateQuestionCount() {
        questionCount += 1;  // Increase question count by 1
    }

    // Getter method to return the player's current score
    public int getPlayerScore() {
        return playerScore;  // Return the player's score
    }

    // Getter method to return the player's remaining lives
    public int getPlayerLives() {
        return playerLives;  // Return the player's lives
    }

    // Getter method to return the number of questions answered
    public int getQuestionCount() {
        return questionCount;  // Return the question count
    }
    
    public void resetStats() {
        playerScore = 0;
        playerLives = 3;
        questionCount = 0;
    }

}

