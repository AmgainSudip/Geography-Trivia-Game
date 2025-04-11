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
        System.out.println("==============================================");
        System.out.println("       Welcome to the Geography Trivia Game!  ");
        System.out.println("==============================================\n");
        
        // Main menu loop
        while(true) {  
            System.out.println("Main Menu:");
            System.out.println("---------------------------------------------------");
            System.out.println("1. Start Game");
            System.out.println("2. Game Instructions");
            System.out.println("3. Exit");
            System.out.println("---------------------------------------------------");
            System.out.print("Enter your input (1-3): ");
            int input = scnr.nextInt();  // Read the user's input
            scnr.nextLine();  // Consume any newline characters left in the input buffer
            System.out.println();  // Add a blank line for spacing
            
            // Start the game if the user selects option 1
            if (input == 1) {
                System.out.println("Select a Difficulty Level:");
                System.out.println("---------------------------------------------------");
                System.out.println("1. Easy   - Beginner-friendly questions.");
                System.out.println("2. Medium - Intermediate challenges.");
                System.out.println("3. Hard   - Advanced geography questions.");
                System.out.println("---------------------------------------------------");
                System.out.print("Enter the number of your choice: ");
                
                int levelChoice = scnr.nextInt();
                scnr.nextLine();
                System.out.println("\nStarting game... Good luck!\n");
                
                // Gameplay loop per level
                while(true) {  
                    // For Easy Level
                    if (levelChoice == 1) {
                        player.resetStats();
                        System.out.println("---------- EASY LEVEL ----------\n");
                        for (int i = 0; i < 10; i++) { // Loop to ask 10 questions
                            System.out.println("Question " + (i + 1) + ":");
                            questionBank.easyQuestion();  // Ask an easy question
                            player.updateQuestionCount();  // Update question count for the player
                            System.out.print("Your answer: ");
                            userInput = scnr.nextLine();  // Get the user's answer
                            
                            if (questionBank.checkAnswer(userInput)) {
                                System.out.println("\n✓ Correct!");
                                System.out.println(questionBank.getDescription());
                                player.updatePlayerScore();
                            } else {
                                System.out.println("\n✗ Incorrect!");
                                System.out.println(questionBank.getDescription());
                                player.updatePlayerLives();
                            }
                            
                            System.out.println("Points: " + player.getPlayerScore() + " | Lives: " + player.getPlayerLives());
                            System.out.println("---------------------------------\n");
                            
                            if (player.getPlayerLives() == 0) {
                                System.out.println("You are out of lives. Game Over.\n");
                                break;
                            }
                        }

                        // End-of-level message
                        System.out.println("========== Level Complete ==========");
                        System.out.println("Easy Level Final Score: " + player.getPlayerScore());
                        System.out.println("Lives Remaining: " + player.getPlayerLives());
                        System.out.println("====================================\n");

                        System.out.print("Do you want to try another level? (yes/no): ");
                        userInput = scnr.nextLine();
                        if (userInput.equalsIgnoreCase("yes")) {
                            System.out.println();
                            System.out.println("Select a Difficulty Level:");
                            System.out.println("---------------------------------------------------");
                            System.out.println("1. Easy");
                            System.out.println("2. Medium");
                            System.out.println("3. Hard");
                            System.out.println("---------------------------------------------------");
                            System.out.print("Enter the number of your choice: ");
                            levelChoice = scnr.nextInt();
                            scnr.nextLine();
                            System.out.println();
                        } else {
                            break;
                        }
                    }
                    // For Medium Level
                    else if (levelChoice == 2) {
                        player.resetStats();
                        System.out.println("--------- MEDIUM LEVEL ---------\n");
                        for (int i = 0; i < 10; i++) { // Loop to ask 10 questions
                            System.out.println("Question " + (i + 1) + ":");
                            questionBank.mediumQuestion();  // Ask a medium question
                            player.updateQuestionCount();  // Update question count for the player
                            System.out.print("Your answer: ");
                            userInput = scnr.nextLine();  // Get the user's answer
                            
                            if (questionBank.checkAnswer(userInput)) {
                                System.out.println("\n✓ Correct!");
                                System.out.println(questionBank.getDescription());
                                player.updatePlayerScore();
                            } else {
                                System.out.println("\n✗ Incorrect!");
                                System.out.println(questionBank.getDescription());
                                player.updatePlayerLives();
                            }
                            
                            System.out.println("Points: " + player.getPlayerScore() + " | Lives: " + player.getPlayerLives());
                            System.out.println("---------------------------------\n");
                            
                            if (player.getPlayerLives() == 0) {
                                System.out.println("You are out of lives. Game Over.\n");
                                break;
                            }
                        }

                        // End-of-level message
                        System.out.println("========== Level Complete ==========");
                        System.out.println("Medium Level Final Score: " + player.getPlayerScore());
                        System.out.println("Lives Remaining: " + player.getPlayerLives());
                        System.out.println("====================================\n");

                        System.out.print("Do you want to try another level? (yes/no): ");
                        userInput = scnr.nextLine();
                        if (userInput.equalsIgnoreCase("yes")) {
                            System.out.println();
                            System.out.println("Select a Difficulty Level:");
                            System.out.println("---------------------------------------------------");
                            System.out.println("1. Easy");
                            System.out.println("2. Medium");
                            System.out.println("3. Hard");
                            System.out.println("---------------------------------------------------");
                            System.out.print("Enter the number of your choice: ");
                            levelChoice = scnr.nextInt();
                            scnr.nextLine();
                            System.out.println();
                        } else {
                            break;
                        }
                    }
                    // For Hard Level
                    else if (levelChoice == 3) {
                        player.resetStats();
                        System.out.println("---------- HARD LEVEL ----------\n");
                        for (int i = 0; i < 10; i++) { // Loop to ask 10 questions
                            System.out.println("Question " + (i + 1) + ":");
                            questionBank.hardQuestion();  // Ask a hard question
                            player.updateQuestionCount();  // Update question count for the player
                            System.out.print("Your answer: ");
                            userInput = scnr.nextLine();  // Get the user's answer
                            
                            if (questionBank.checkAnswer(userInput)) {
                                System.out.println("\n✓ Correct!");
                                System.out.println(questionBank.getDescription());
                                player.updatePlayerScore();
                            } else {
                                System.out.println("\n✗ Incorrect!");
                                System.out.println(questionBank.getDescription());
                                player.updatePlayerLives();
                            }
                            
                            System.out.println("Points: " + player.getPlayerScore() + " | Lives: " + player.getPlayerLives());
                            System.out.println("---------------------------------\n");
                            
                            if (player.getPlayerLives() == 0) {
                                System.out.println("You are out of lives. Game Over.\n");
                                break;
                            }
                        }

                        // End-of-level message
                        System.out.println("========== Level Complete ==========");
                        System.out.println("Hard Level Final Score: " + player.getPlayerScore());
                        System.out.println("Lives Remaining: " + player.getPlayerLives());
                        System.out.println("====================================\n");

                        System.out.print("Do you want to try another level? (yes/no): ");
                        userInput = scnr.nextLine();
                        if (userInput.equalsIgnoreCase("yes")) {
                            System.out.println();
                            System.out.println("Select a Difficulty Level:");
                            System.out.println("---------------------------------------------------");
                            System.out.println("1. Easy");
                            System.out.println("2. Medium");
                            System.out.println("3. Hard");
                            System.out.println("---------------------------------------------------");
                            System.out.print("Enter the number of your choice: ");
                            levelChoice = scnr.nextInt();
                            scnr.nextLine();
                            System.out.println();
                        } else {
                            break;
                        }
                    }
                }
            }
            // Display instructions when the user selects option 2
            else if (input == 2) {
                System.out.println("********************** GAME INSTRUCTIONS **********************");
                System.out.println("1. Difficulty Levels:");
                System.out.println("   - Easy: Beginner-friendly questions.");
                System.out.println("   - Medium: Intermediate challenges.");
                System.out.println("   - Hard: Advanced geography questions.");
                System.out.println("2. Objective: Answer each of the 10 questions correctly to earn 10 points per question.");
                System.out.println("3. Lives: You start with 3 lives. Each wrong answer deducts one life.");
                System.out.println("4. Gameplay: Your current score and remaining lives are displayed after each question.");
                System.out.println("5. Post-Level Option: After completing a level, you can choose another difficulty or exit the game.");
                System.out.println("****************************************************************\n");
            }
            // End the game if the user selects option 3
            else if (input == 3) {
                System.out.println("Thank you for playing! Goodbye!");
                break;
            }
        }

        scnr.close();
    }
}
