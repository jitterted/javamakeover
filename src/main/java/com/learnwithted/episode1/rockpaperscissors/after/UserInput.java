package com.learnwithted.episode1.rockpaperscissors.after;

import java.util.Scanner;

/**
 * This is the code after refactoring in Episode 1 of Java Makeover: https://www.twitch.tv/videos/382302523
 */
public class UserInput {

  private final Scanner scanner;

  public UserInput() {
    scanner = new Scanner(System.in);
  }

  public Choice nextChoice(Choice[] choices) {
    System.out.print("Please type the first letter of these choices: ");
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
                             + "S for scissors, and press enter.");
    }

  }
}
