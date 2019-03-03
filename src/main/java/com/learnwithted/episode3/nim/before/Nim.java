package com.learnwithted.episode3.nim.before;

import java.util.Random;
import java.util.Scanner;

/*
 * https://www.reddit.com/r/learnjava/comments/9d032y/anyone_able_to_review_my_code_for_a_nim_game/
 */
public class Nim {

  //	Internal game data - players, piles, AI, display setting etc...
  private Player[] players = new Player[2];
  private Pile[] piles = new Pile[3];
  private boolean ai = false;
  private boolean displayMode = true;  // true for column display, false for numerical
  private Scanner sc = new Scanner(System.in);
  private Random rng = new Random();

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
    Pile chosenPile = null;

    String answer;
    String countersTaken;

    int counters = numberOfCounters();
    while (counters != 0) {
      if (isPlayerOne) {
        currentPlayer = players[0];
        isPlayerOne = false;
      } else {
        currentPlayer = players[1];
        isPlayerOne = true;
      }

      if (counters == 1) break;

      printPiles();

      if (ai && currentPlayer.getName().equals("CPU")) {
        String[] piles = {this.piles[0].getName(), this.piles[1].getName(), this.piles[2].getName()};
        String cpuPile;
        do {
          cpuPile = piles[rng.nextInt(3)];
          chosenPile = getPile(cpuPile);
        } while (chosenPile.getCounters() < 1);
        System.out.println("CPU has chosen " + cpuPile);
      } else {
        do {
          System.out.print(currentPlayer.getName() + ", choose a pile: ");
          answer = sc.nextLine().trim();
        } while (!isPileValid(answer));
        chosenPile = getPile(answer);
      }

      int amount = 0;
      if (ai && currentPlayer.getName().equals("CPU")) {
        amount = rng.nextInt(chosenPile.getCounters()) + 1;
        System.out.println("CPU has taken " + amount + " counters");
      } else {
        do {
          System.out.print("How many to remove from pile " + chosenPile.getName() + ": ");
          countersTaken = sc.nextLine().trim();
        } while (!isCounterValid(countersTaken, chosenPile));
        amount = Integer.parseInt(countersTaken);
      }

      chosenPile.setCounters(chosenPile.getCounters() - amount);
      counters = numberOfCounters();
    }

    printPiles();

    System.out.println((counters == 0) ? "\nAll piles are empty. " + currentPlayer.getName() + " lost the match!" : "\n" +
                                                                                                                        currentPlayer
                                                                                                                            .getName() + ", there is only one counter left, so you lose automatically.");
  }

  //	Introductory to the game method
  private void intro() {
    System.out.printf("Welcome to Nim, a simple strategy game between two players.%n");
    System.out.printf("%nThe rules are simple:%n* Each player alternates turns and takes counters from a pile%n* At least one counter must be taken. " +
                          "%n* If a player cannot take a counter or last counter remains, that player loses.%n%nAdditionally, you can play versus a computer by naming the first or second player 'CPU'%n");
    System.out.println("Good Luck!\n");
  }

  //	Support methods. Used in aiding the main gameplay method (printing of piles, how many counters are left etc...)
  private Pile getPile(String name) {
    for (Pile i : piles)
      if (i.getName().equals(name)) return i;
    return null;
  }

  private void printPiles() {
    if (displayMode) {
      displayPilesColumn();
    } else {
      displayPilesNumerical();
    }
    System.out.println();
  }

  private int numberOfCounters() {
    int total = 0;
    for (Pile i : piles)
      total += i.getCounters();
    return total;
  }

  //	Column pattern display
  private void displayPilesColumn() {
    int highest = Math.max(Math.max(piles[0].getCounters(), piles[1].getCounters()), piles[2].getCounters());
    System.out.println();
    for (int i = highest; i >= 1; i--) {
      if (piles[0].getCounters() >= i)
        System.out.print("* ");
      else
        System.out.print("  ");

      if (piles[1].getCounters() >= i)
        System.out.print(" * ");
      else
        System.out.print("   ");

      if (piles[2].getCounters() >= i)
        System.out.print(" *");
      else
        System.out.print("  ");

      System.out.println();
    }
    System.out.printf("%s  %s  %s%n", piles[0].getName(), piles[1].getName(), piles[2].getName());
  }

  //	Numerical pattern display
  private void displayPilesNumerical() {
    System.out.printf("%n%s%15s%15s%n", piles[0], piles[1], piles[2]);
  }

  //	Game startup initialization method. Initialize the counters, player names etc...
  private void init() {
    String player1;
    String player2;

    String display;
    System.out.print("Before we begin, please select what type of display for counters do you wish to use ('column' or 'numerical'): ");
    while (true) {
      display = sc.nextLine();
      System.out.println();
      if (display.equalsIgnoreCase("numerical")) {
        displayMode = false;
        break;
      }
      if (display.equalsIgnoreCase("column")) break;
      System.out.printf("Invalid input.%n");
    }

    System.out.print("Player 1, enter your name: ");
    player1 = sc.nextLine();
    System.out.print("Player 2, enter your name: ");
    player2 = sc.nextLine();

    if (player1.equals("CPU") || player2.equals("CPU")) ai = true;

    Player p1 = new Player(player1);
    Player p2 = new Player(player2);

    players[0] = p1;
    players[1] = p2;

    int c1 = rng.nextInt(3) + 3;
    int c2 = rng.nextInt(3) + 3;
    int c3 = rng.nextInt(3) + 3;

    Pile pl1 = new Pile("A", c1);
    Pile pl2 = new Pile("B", c2);
    Pile pl3 = new Pile("C", c3);

    piles[0] = pl1;
    piles[1] = pl2;
    piles[2] = pl3;
  }

  //	Validation methods, used to check if player's input is correct
  private boolean isPileValid(String name) {
    Pile pile = null;
    for (Pile i : piles) {
      if (i.getName().equals(name)) {
        pile = i;
        break;
      }
    }

    if (pile != null) {
      if (pile.getCounters() != 0) {
        return true;
      } else {
        System.out.println("That pile is already empty. Try again.\n");
        return false;
      }
    } else {
      System.out.println("No pile exists with that name. Try again.\n");
      return false;
    }
  }

  private boolean isCounterValid(String counters, Pile pile) {
    try {
      int n = Integer.parseInt(counters);
      if (n <= 0) {
        System.out.println("You cannot take 0 or less counters. Try again.\n");
        return false;
      } else if (n > pile.getCounters()) {
        System.out.println("You cannot take more counters from a pile than it already has it. Try again.\n");
        return false;
      }
      return true;
    } catch (NumberFormatException e) {
      System.out.println("Invalid number given!\n");
      return false;
    }
  }
}
