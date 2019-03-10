package com.learnwithted.episode4.hangman.after;

import java.util.Scanner;

/**
 * From: https://raw.githubusercontent.com/kelliet/Hangman/master/src/Main.java
 */
public class KellietHangman {

  public static void main(String[] args) {
//        1)	At the start of your application the user
//        will be prompted for the puzzle to be presented
//        to the player. Limit the puzzle to at least 1
//        word and no more than 8.
//        Loop the prompt until the puzzle is valid.
    Scanner scanner = new Scanner(System.in);
    String puzzle = puzzlePhrase(scanner);

//        2)	Once the puzzle is entered display the game. The game display consists of
//        the gallows (for the “Man” we’re trying not to hang), the puzzle itself, and the
//        current collection of letters guessed. The puzzle is displayed with underscores for
//        every letter that needs to be guessed. Spaces, apostrophes, quotation marks and other
//        punctuation should be displayed as normal. Only letters should be concealed.

    String[] hangman = initializePuzzleDisplay(puzzle);
    displayPuzzle(hangman);

    //        3)	The game is played in rounds. Each round the player may guess a letter,
//        solve the puzzle, or give up. These options should be presented in menu form each
//        time the game display is printed.

    PlayerGuesses playerGuesses = new PlayerGuesses();
    int wrongAnswerCount = 0;
    boolean continuePlaying = true;
    while (continuePlaying) {
      System.out.println("Please enter 1 to guess a letter, 2 to solve the puzzle, or 3 to quit.");
      String menuChoice = scanner.nextLine();
      switch (menuChoice) {
        case "1":
          wrongAnswerCount = doOnePlayerGuess(scanner, puzzle, hangman, playerGuesses, wrongAnswerCount);
          break;
        case "2":
          //doSolvePuzzle();
          break;
        case "3":
          continuePlaying = false;
          break;
        default:
          System.out.println("Didn't understand " + menuChoice);
          break;
      }
    }

  }

  private static int doOnePlayerGuess(Scanner scanner, String puzzle, String[] hangman, PlayerGuesses playerGuesses, int wrongAnswerCount) {
    System.out.println("Please enter the letter");
    String playerGuess = scanner.nextLine();
    playerGuesses.addGuess(playerGuess);

    if (guessIsCorrect(puzzle, playerGuess)) {

      updateDisplayWithCorrectGuess(puzzle, hangman, playerGuess);

      displayPuzzle(hangman);

      playerGuesses.display();

      System.out.println("");
    } else {
      if (!playerGuesses.hasBeenGuessed(playerGuess)) {
        wrongAnswerCount++;
      }

      displayHangman(wrongAnswerCount);
    }
    return wrongAnswerCount;
  }

  private static void displayHangman(int wrongAnswer) {
    System.out.println("   ____");
    System.out.println("   |   |");
    if (wrongAnswer >= 1)
      System.out.println("   |   O");
    if (wrongAnswer >= 2)
      System.out.println("   |   |");
    if (wrongAnswer >= 3)
      System.out.println("   |   |/");
    if (wrongAnswer >= 4)
      System.out.println("   |   \\|/");
    if (wrongAnswer >= 5)
      System.out.println("   |      \\");
    if (wrongAnswer >= 5)
      System.out.println("   |     /\\");
    System.out.println("   |");
    System.out.println("___|___");
  }

  private static boolean guessIsCorrect(String puzzle, String playerGuess) {
    return puzzle.contains(playerGuess);
  }

  private static void updateDisplayWithCorrectGuess(String puzzle, String[] hangman, String playerGuess) {
    for (int i = 0; i < puzzle.length(); i++) {
      if (Character.toString(puzzle.charAt(i)).equals(playerGuess)) {
        hangman[i] = playerGuess;
      }
    }
  }

  private static void displayPuzzle(String[] hangman) {
    for (int i = 0; i < hangman.length; i++) {
      System.out.print(hangman[i]);
    }
    System.out.println("");
  }

  private static String[] initializePuzzleDisplay(String input) {
    String[] hangman = new String[input.length()];
    for (int i = 0; i < input.length(); i++) {
      hangman[i] = populateHangman(Character.toString(input.charAt(i)));
    }
    return hangman;
  }

  private static String puzzlePhrase(Scanner scanner) {
    String input = "";

    while (true) {
      System.out.println("Please enter a word or phrase for hangman.");
      System.out.println("At least one word but no more than 8.");
      input = scanner.nextLine();
      String[] words = input.split(" ");
      if (!input.isEmpty() && words.length <= 8 && words.length > 0) {
        break;
      }
    }
    return input;
  }


  public static String populateHangman(String value) {

    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    if (alphabet.contains(value))
      return "_ ";
    else
      return value;

  }


}
