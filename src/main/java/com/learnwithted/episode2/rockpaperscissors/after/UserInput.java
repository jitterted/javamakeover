package com.learnwithted.episode2.rockpaperscissors.after;

import java.util.Scanner;

/**
 * This is the code after adding Lizard & Spock to the game.
 * Featured in Episode 2 of Java Makeover: https://www.twitch.tv/videos/384937583
 */
public class UserInput {

  private final Scanner scanner;

  public UserInput() {
    scanner = new Scanner(System.in);
  }

  public Choice nextChoice(Choice[] choices) {
    System.out.print("Please type the first letter (or two) of these choices: ");
    for (Choice choice : choices) {
      System.out.print(choice + ", ");
    }
    System.out.println();

    while (true) {
      String input = scanner.nextLine().toUpperCase();

      for (Choice choice : choices) {
        if (choice.toString().startsWith(input)) {
          return choice;
        }
      }
      System.out.println("That is not a choice. Please type in R for Rock, P for Paper or "
                             + "SC for Scissors, L for Lizard, and SP for Spock" +
                             " and press Enter.");
    }

  }
}
