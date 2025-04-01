package trivia.game;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameManager { // Controls game flow
	
	public static void main(String[] args) throws FileNotFoundException {
		String userInput;
		Scanner scnr = new Scanner(System.in); 
		
		PlayerStats player = new PlayerStats();
		QuestionBank questionBank = new QuestionBank();
		
		System.out.println("Welcome to the Geography Trivia Game!");
		System.out.println("If you want to start the game type 1.\nIf you want the instructions on how to play the game type 2.\nIf you want to end the game type 3.");
		
		while(true) {
		System.out.print("Enter your input: ")
		int input = scnr.nextInt();
		scnr.nextLine();
		
		if (input == 1) {
			while(true) {
				System.out.println("Starting the game! Let see what you got.");
					if (player.getPlayerScore() < 50) {
						System.out.println();
						questionBank.easyQuestion();
						player.updateQuestionCount();
						userInput = scnr.nextLine();
						
						if (questionBank.checkAnswer(userInput)) {
							System.out.println("Correct!");
							player.updatePlayerScore();
							System.out.println("You currently have " + player.getPlayerScore() + " points.");
							System.out.println("You have " + player.getPlayerLives() + " lives remaining.");
		
						}
						
						else {
							System.out.println("Incorrect!");
							player.updatePlayerLives();
							System.out.println("You have " + player.getPlayerLives() + " lives remaining.");
			
							if (player.getPlayerLives() == 0) {
								System.out.println("\nYou are out of lives.\nGame Over.");
								break;
							}
							
							else {
								continue;
							}
						}
					}
				
				else if (player.getPlayerScore() < 100) {
					System.out.println();
					questionBank.mediumQuestion();
					player.updateQuestionCount();
					userInput = scnr.nextLine();
					
					if (questionBank.checkAnswer(userInput)) {
						System.out.println("Correct!");
						player.updatePlayerScore();
						System.out.println("You currently have " + player.getPlayerScore() + " points.");
						System.out.println("You have " + player.getPlayerLives() + " lives remaining.");
	
					}
					
					else {
						System.out.println("Incorrect!");
						player.updatePlayerLives();
						System.out.println("You have " + player.getPlayerLives() + " lives remaining.");
						
						if (player.getPlayerLives() == 0) {
							System.out.println("You are out of lives.\nGame Over");
							break;
						}
						
						else {
							continue;
						}
					}
					
					
				}
				
				else {
					if (player.getQuestionCount() < 20) { 
						System.out.println();
						questionBank.hardQuestion();
						player.updateQuestionCount();
						userInput = scnr.nextLine();
						
						if (questionBank.checkAnswer(userInput)) {
							if (player.getQuestionCount() < 20) {
								System.out.println("Correct!");
								player.updatePlayerScore();
								System.out.println("You currently have " + player.getPlayerScore() + " points.");
								System.out.println("You have " + player.getPlayerLives() + " lives remaining.");
							}
							
							else {
								System.out.println("Correct!");
								player.updatePlayerScore();
							}
						}
							
						
						else {
							System.out.println("Incorrect!");
							
							if (player.getQuestionCount() < 20) {
								player.updatePlayerLives();
								System.out.println("You have " + player.getPlayerLives() + " lives remaining.");
							}
							
							else {
								player.updatePlayerLives();
							}
							
							if (player.getPlayerLives() == 0) {
								System.out.println("You are out of lives.\nGame Over");
								break;
							}
							
							else {
								continue;
							}
						}
					}
					
					else {
						if (player.getPlayerScore() == 200) {
							System.out.println("\nWell done, explorer! You've conquered the geography game! Ready for another journey around the world?");
							break;
						}
						
						else {
							System.out.println("\nYou finished with " + player.getPlayerScore() + " points! Can you beat your score next time?");						
							break;
						}
					}
				}
				
			
		}
			
		}
		else if (input == 2) {
			System.out.println("Welcome to the Geography Quiz Game!\n");
	        System.out.println("Here’s how to play:");
	        System.out.println("1. Objective: Answer as many questions correctly as possible to earn points. Try to get all 20 questions correct!");
	        System.out.println("2. Lives: You start with 3 lives. If you answer a question incorrectly, you lose a life. If you lose all your lives, the game ends.");
	        System.out.println("3. Points: For each correct answer, you earn 10 points. Your total score will increase with each correct answer.");
	        System.out.println("4. Unlocking Difficult Questions: ");
	        System.out.println("   - When you reach 50 points, you'll unlock the Medium difficulty questions.");
	        System.out.println("   - When you reach 100 points, you'll unlock the Hard difficulty questions.");
	        System.out.println("5. Gameplay: ");
	        System.out.println("   - The game consists of 20 questions in total.");
	        System.out.println("   - If you don’t lose all your lives, you can play through all the questions.");
	        System.out.println("   - Your score and remaining lives will be shown after each question.");
	        System.out.println("6. Game Over: ");
	        System.out.println("   - The game ends when you either finish all the questions or lose all your lives.");
	        System.out.println("\nGood luck, and may the best geographer win!");
	        
	        System.out.println("\nIf you want to start the game type 1, to end the game type 3.")
	        continue;
	        
		}
		
		else if (input == 3) {
			System.out.println("See you soon!");
			break;
		}
	
	}
}
	
}
