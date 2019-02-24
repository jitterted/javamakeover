package com.learnwithted.episode1.rockpaperscissors.before;

import java.util.Random;
import java.util.Scanner;

/**
 * From https://www.reddit.com/r/javahelp/comments/aqd1nq/getting_an_error_and_need_some_help/
 */
public class GameApp {

  public static void main(String[] args) {
    while (true) {
      Scanner myObj = new Scanner(System.in);
      System.out.println("Welcome to the Rock, Paper Scissors game! ");
      System.out.println("Please pick between rock(R,paper(P) or scissors(S): ");

      Scanner choice = new Scanner(System.in);
      int rps = choice.nextInt();

      Random cChoice = new Random();
      int cChoiceRand = cChoice.nextInt(3) + 1;


      if (rps < 4 && rps > 0) {
        if (rps == 1)
          System.out.println("You chose Rock");
        if (rps == 2)
          System.out.println("You Chose Paper");
        if (rps == 3)
          System.out.println("You Chose Scissors");

        if (cChoiceRand == 1)
          System.out.println("The computer chose:Rock");
        if (cChoiceRand == 2)
          System.out.println("The computer chose:Paper");
        if (cChoiceRand == 3)
          System.out.println("The computer chose:Scissors");

        System.out.println("The winner is");

        if (rps == cChoiceRand)
          System.out.println("   a tie");
        if (rps == cChoiceRand + 1)
          System.out.println("   you win");
        if (rps == cChoiceRand - 1)
          System.out.println("    the computer wins");

        System.out.println("----------------------------------------");

      }

      if (rps > 3 || rps < 1) {
        System.out.println("That is not a choice. Please type in 1 for rock, 2 for paper or"
                               + "3 for scissors, and press enter.");
        System.out.println("-------------------------------------------------------------------------------");

      }
    }
  }

}