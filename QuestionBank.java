package trivia.game;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class QuestionBank { 
    private Random random = new Random();  // Random object for selecting questions
    private String correctAnswer = "";  // Holds the correct answer to the current question
    
    // Separate lists to store questions of different difficulty levels
    private List<String> easyQuestions = new ArrayList<>();
    private List<String> mediumQuestions = new ArrayList<>();
    private List<String> hardQuestions = new ArrayList<>();

    // Method to load and ask an easy question
    public void easyQuestion() throws FileNotFoundException {
        if (easyQuestions.isEmpty()) {
            loadQuestions("easy", easyQuestions);  // Load questions if list is empty
        }
        askQuestion(easyQuestions);  // Ask a question from the easy list
    }

    // Method to load and ask a medium question
    public void mediumQuestion() throws FileNotFoundException {
        if (mediumQuestions.isEmpty()) {
            loadQuestions("medium", mediumQuestions);  // Load questions if list is empty
        }
        askQuestion(mediumQuestions);  // Ask a question from the medium list
    }

    // Method to load and ask a hard question
    public void hardQuestion() throws FileNotFoundException {
        if (hardQuestions.isEmpty()) {
            loadQuestions("hard", hardQuestions);  // Load questions if list is empty
        }
        askQuestion(hardQuestions);  // Ask a question from the hard list
    }

    // Method to ask a question from the given question list
    private void askQuestion(List<String> questionList) {
        if (questionList.isEmpty()) {
            System.out.println("No more questions available.");  // Notify if no questions are left
            return;
        }

        int randomNum = random.nextInt(questionList.size());  // Randomly select a question
        String line = questionList.remove(randomNum);  // Remove used question
        String[] parts = line.split("\\|");  // Split the question and answers by '|'

        if (parts.length == 6) {
            System.out.println(parts[0]);  // Display the question
            System.out.println("A) " + parts[1].trim());  // Option A
            System.out.println("B) " + parts[2].trim());  // Option B
            System.out.println("C) " + parts[3].trim());  // Option C
            System.out.println("D) " + parts[4].trim());  // Option D
            correctAnswer = parts[5].trim();  // Set the correct answer (A, B, C, or D)
        } else {
            System.out.println("Invalid question format.");  // Handle invalid question format
        }
    }

    // Method to load questions from a file into the corresponding question list
    private void loadQuestions(String filename, List<String> questionList) throws FileNotFoundException {
        File file = new File(filename);  // Open file based on difficulty level
        Scanner scnr = new Scanner(file);  // Scanner to read the file
        while (scnr.hasNextLine()) {
            questionList.add(scnr.nextLine());  // Add each line (question) to the list
        }
        scnr.close();  // Close the scanner
    }

    // Method to check if the user's answer is correct
    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);  // Compare user input with correct answer
    }
}

