# Trivia Game

This is a simple trivia game implemented in Java. The game allows the user to answer questions from three categories: **Easy**, **Medium**, and **Hard**. The questions are randomly selected from the corresponding category files, and the user is asked to select the correct answer from multiple choices.

## Features

- Three difficulty levels: Easy, Medium, and Hard
- Random selection of questions from each category
- Answer checking system
- Removes questions from the list once they are asked
- Prompts when all questions in a category are exhausted

## Requirements

- Java 8 or higher
- Questions files (`easy.txt`, `medium.txt`, `hard.txt`)

## Setup

1. Clone the repository to your local machine:
   git clone https://github.com/AmgainSudip/trivia-game.git
   
3. Naviagte to the project directory:
  cd trivia-game

4. Place your question files (easy, medium, hard) in the project folder. Each file should contain questions in the following format:
   Question text | Option A | Option B | Option C | Option D | Correct Answer

5. javac trivia/game/*.java
  java trivia.game.Main

Game Usage
The game will prompt the user with a question and four options.
The user must select the correct option (A, B, C, or D).
The game will provide feedback on whether the user's answer is correct.

