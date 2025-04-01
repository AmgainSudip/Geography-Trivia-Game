package trivia.game;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameManager { // Controls game flow
	
	public static void main(String[] args) throws FileNotFoundException {
		String userInput;  // Variable to store the user's input
		Scanner scnr = new Scanner(System.in);  // Scanner to read user input
		
		PlayerStats player = new PlayerStats();  // Create an instance of PlayerStats to keep track of player data
		QuestionBank questionBank = new QuestionBank();  // Create an instance of QuestionBank to handle questions
		
		// Display the welcome message and game options
		System.out.println("Welcome to the Geography Trivia Game!");

		
		while(true) {  // Loop to keep the game running until the user decides to quit
			System.out.println("If you want to start the game type 1.\nIf you want the instructions on how to play the game type 2.\nIf you want to end the game type 3.");
			System.out.print("Enter your input: ");
			int input = scnr.nextInt();  // Read the user's input
			scnr.nextLine();  // Consume any newline characters left in the input buffer
			
			// Start the game if the user selects option 1
			if (input == 1) {
				while(true) {  // Loop to control the gameplay
					System.out.println("Starting the game! Let's see what you got.");
					
					// If player's score is below 50, ask easy questions
					if (player.getPlayerScore() < 50) {
						System.out.println();
						questionBank.easyQuestion();  // Ask an easy question
						player.updateQuestionCount();  // Update question count for the player
						userInput = scnr.nextLine();  // Get the user's answer
						
						// Check if the user's answer is correct
						if (questionBank.checkAnswer(userInput)) {
							System.out.println("Correct!");
							player.updatePlayerScore();  // Update player's score for a correct answer
							System.out.println("You currently have " + player.getPlayerScore() + " points.");
							System.out.println("You have " + player.getPlayerLives() + " lives remaining.");
						} else {
							System.out.println("Incorrect!");
							player.updatePlayerLives();  // Reduce player's lives for an incorrect answer
							System.out.println("You have " + player.getPlayerLives() + " lives remaining.");
							
							// End the game if the player runs out of lives
							if (player.getPlayerLives() == 0) {
								System.out.println("\nYou are out of lives.\nGame Over.");
								break;
							} else {
								continue;  // Continue the game if the player still has lives
							}
						}
					}
					
					// If the player's score is between 50 and 100, ask medium questions
					else if (player.getPlayerScore() < 100) {
						System.out.println();
						questionBank.mediumQuestion();  // Ask a medium question
						player.updateQuestionCount();  // Update question count for the player
						userInput = scnr.nextLine();  // Get the user's answer
						
						// Check if the user's answer is correct
						if (questionBank.checkAnswer(userInput)) {
							System.out.println("Correct!");
							player.updatePlayerScore();  // Update player's score for a correct answer
							System.out.println("You currently have " + player.getPlayerScore() + " points.");
							System.out.println("You have " + player.getPlayerLives() + " lives remaining.");
						} else {
							System.out.println("Incorrect!");
							player.updatePlayerLives();  // Reduce player's lives for an incorrect answer
							System.out.println("You have " + player.getPlayerLives() + " lives remaining.");
							
							// End the game if the player runs out of lives
							if (player.getPlayerLives() == 0) {
								System.out.println("You are out of lives.\nGame Over");
								break;
							} else {
								continue;  // Continue the game if the player still has lives
							}
						}
					}
					
					// If the player's score is above 100, ask hard questions
					else {
						// If the player has answered fewer than 20 questions, ask hard questions
						if (player.getQuestionCount() < 20) { 
							System.out.println();
							questionBank.hardQuestion();  // Ask a hard question
							player.updateQuestionCount();  // Update question count for the player
							userInput = scnr.nextLine();  // Get the user's answer
							
							// Check if the user's answer is correct
							if (questionBank.checkAnswer(userInput)) {
								System.out.println("Correct!");
								player.updatePlayerScore();  // Update player's score for a correct answer
								System.out.println("You currently have " + player.getPlayerScore() + " points.");
								System.out.println("You have " + player.getPlayerLives() + " lives remaining.");
							} else {
								System.out.println("Incorrect!");
								player.updatePlayerLives();  // Reduce player's lives for an incorrect answer
								System.out.println("You have " + player.getPlayerLives() + " lives remaining.");
							}
							
							// End the game if the player runs out of lives
							if (player.getPlayerLives() == 0) {
								System.out.println("You are out of lives.\nGame Over");
								break;
							} else {
								continue;  // Continue the game if the player still has lives
							}
						}
						
						// If all questions are answered or the player runs out of lives, end the game
						else {
							if (player.getPlayerScore() == 200) {
								System.out.println("\nWell done, explorer! You've conquered the geography game! Ready for another journey around the world?");
								break;
							} else {
								System.out.println("\nYou finished with " + player.getPlayerScore() + " points! Can you beat your score next time?");
								break;
							}
						}
					}
				}
			}
			
			// Show instructions when the user selects option 2
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
		        continue;  // Continue to the next iteration of the menu
		
			}
			
			// End the game if the user selects option 3
			else if (input == 3) {
				System.out.println("See you soon!");
				break;  // Exit the game loop
			}
		}
	}
}

