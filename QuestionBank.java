package trivia.game;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class QuestionBank { 
    private Random random = new Random();
    private String correctAnswer = "";
    
    // Separate lists for different difficulty levels
    private List<String> easyQuestions = new ArrayList<>();
    private List<String> mediumQuestions = new ArrayList<>();
    private List<String> hardQuestions = new ArrayList<>();

    public void easyQuestion() throws FileNotFoundException {
        if (easyQuestions.isEmpty()) {
            loadQuestions("easy", easyQuestions);
        }
        askQuestion(easyQuestions);
    }

    public void mediumQuestion() throws FileNotFoundException {
        if (mediumQuestions.isEmpty()) {
            loadQuestions("medium", mediumQuestions);
        }
        askQuestion(mediumQuestions);
    }

    public void hardQuestion() throws FileNotFoundException {
        if (hardQuestions.isEmpty()) {
            loadQuestions("hard", hardQuestions);
        }
        askQuestion(hardQuestions);
    }

    private void askQuestion(List<String> questionList) {
        if (questionList.isEmpty()) {
            System.out.println("No more questions available.");
            return;
        }

        int randomNum = random.nextInt(questionList.size());
        String line = questionList.remove(randomNum); // Remove used question
        String[] parts = line.split("\\|");

        if (parts.length == 6) {
            System.out.println(parts[0]); // Question
            System.out.println("A) " + parts[1].trim());
            System.out.println("B) " + parts[2].trim());
            System.out.println("C) " + parts[3].trim());
            System.out.println("D) " + parts[4].trim());
            correctAnswer = parts[5].trim(); // Correct answer (A, B, C, or D)
        } else {
            System.out.println("Invalid question format.");
        }

        if (questionList.isEmpty()) {
            System.out.println("Congrats! You completed the game. You are a warrior.");
        }
    }

    private void loadQuestions(String filename, List<String> questionList) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scnr = new Scanner(file);
        while (scnr.hasNextLine()) {
            questionList.add(scnr.nextLine());
        }
        scnr.close();
    }

    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }
}
