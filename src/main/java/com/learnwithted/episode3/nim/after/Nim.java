package com.learnwithted.episode3.nim.after;

import java.util.Random;
import java.util.Scanner;

/*
 * https://www.reddit.com/r/learnjava/comments/9d032y/anyone_able_to_review_my_code_for_a_nim_game/
 */
public class Nim {

  //	Internal game data - players, piles, AI, display setting etc...
  private Player[] players = new Player[2];
  private Scanner sc = new Scanner(System.in);
  private Random rng = new Random();
  private Piles piles;

  public static void main(String[] args) {
    Nim nim = new Nim();
    nim.intro();
    nim.init();
    nim.start();
  }

  //	Core method. This is where all the answers and calculations happen
  private void start() {
    boolean isPlayerOne = true;
    Player currentPlayer = players[0];

    while (piles.hasCounters()) {
      if (isPlayerOne) {
        currentPlayer = players[0];
        isPlayerOne = false;
      } else {
        currentPlayer = players[1];
        isPlayerOne = true;
      }

      // has current player lost?
      if (piles.isGameOver()) break;

      piles.display();

      Pile chosenPile = currentPlayer.choosePile(piles);

      int amount = currentPlayer.chooseAmount(chosenPile);

      chosenPile.removeCounters(amount);
    }

    // end of game
    piles.display();

    System.out.println((piles.isEmpty()) ? "\nAll piles are empty. "
                                               + currentPlayer.getName()
                                               + " lost the match!"
                           : "\n" + currentPlayer.getName()
                                 + ", there is only one counter left, so you lose automatically.");
  }

  //	Introductory to the game method
  private void intro() {
    System.out.printf("Welcome to Nim, a simple strategy game between two players.%n");
    System.out.printf("%nThe rules are simple:%n* Each player alternates turns and takes counters from a pile%n* At least one counter must be taken. " +
                          "%n* If a player cannot take a counter or last counter remains, that player loses.%n%nAdditionally, you can play versus a computer by naming the first or second player 'CPU'%n");
    System.out.println("Good Luck!\n");
  }


  //	Game startup initialization method. Initialize the counters, player names etc...
  private void init() {
    System.out.print("Before we begin, please select what type of display for counters do you wish to use: column ('c') or numerical ('n'): ");
    while (true) {
      String display = sc.nextLine();
      System.out.println();
      if (display.equalsIgnoreCase("n")) {
        piles = new Piles(false, rng);
        break;
      } else if (display.equalsIgnoreCase("c")) {
        piles = new Piles(true, rng);
        break;
      }
      System.out.printf("Please type 'n' for numerical, or 'c' for column mode.%n");
    }

    System.out.print("Player 1, enter your name: ");
    String player1 = sc.nextLine();

    System.out.print("Player 2, enter your name: ");
    String player2 = sc.nextLine();

    players[0] = Player.create(player1, sc, rng);
    players[1] = Player.create(player2, sc, rng);

  }

}
