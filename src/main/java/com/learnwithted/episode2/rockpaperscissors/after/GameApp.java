package com.learnwithted.episode2.rockpaperscissors.after;

import java.util.Random;

/**
 * This is the code after adding Lizard & Spock to the game.
 * Featured in Episode 2 of Java Makeover: https://www.twitch.tv/videos/384937583
 * <p>
 * Originally From https://www.reddit.com/r/javahelp/comments/aqd1nq/getting_an_error_and_need_some_help/
 */
public class GameApp {

  public static void main(String[] args) {
    UserInput userInput = new UserInput();
    Random random = new Random();
    System.out.println("Welcome to the Rock, Paper, Scissors, Lizard, Spock game!");

    while (true) {
      Choice computerChoice = Choice.values()[random.nextInt(Choice.values().length)];

      Choice userChoice = userInput.nextChoice(Choice.values());

      System.out.println("Your choice: " + userChoice.toString());

      System.out.println("The computer chose: " + computerChoice);

      System.out.print("The winner is: ");
      String winner = determineWinner(userChoice, computerChoice);
      System.out.println(winner);

      System.out.println("-------------------------------------------------------------------------------");
    }
  }

  public static String determineWinner(Choice user, Choice computer) {
    switch (user.against(computer)) {
      case 0:
        return "tie";
      case -1:
        return "computer";
      case 1:
        return "you";
      default:
        return "error";
    }
  }
}