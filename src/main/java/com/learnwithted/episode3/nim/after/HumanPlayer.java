package com.learnwithted.episode3.nim.after;

import java.util.Scanner;

public class HumanPlayer extends Player {
  private final Scanner sc;

  public HumanPlayer(String name, Scanner scanner) {
    super(name);
    sc = scanner;
  }

  @Override
  public Pile choosePile(Piles piles) {
    String pileChoice;
    do {
      System.out.print(getName() + ", choose a pile: ");
      pileChoice = sc.nextLine().trim();
    } while (!piles.isPileValid(pileChoice));

    return piles.getPile(pileChoice);
  }

  @Override
  public int chooseAmount(Pile pile) {
    String countersTaken;
    do {
      System.out.print("How many to remove from pile " + pile.getName() + ": ");
      countersTaken = sc.nextLine().trim();
    } while (!pile.isCounterValid(countersTaken));
    return Integer.parseInt(countersTaken);
  }
}
