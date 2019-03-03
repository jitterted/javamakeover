package com.learnwithted.episode3.nim.after;

import java.util.Random;

public class ComputerPlayer extends Player {
  private final Random rng;

  public ComputerPlayer(String name, Random rng) {
    super(name);
    this.rng = rng;
  }

  @Override
  public Pile choosePile(Piles piles) {
    String pileChoice;
    do {
      String[] pileNames = piles.allNames();
      pileChoice = pileNames[rng.nextInt(3)];
      System.out.println("CPU has chosen " + pileChoice);
    } while (!piles.isPileValid(pileChoice));

    return piles.getPile(pileChoice);
  }

  @Override
  public int chooseAmount(Pile pile) {
    int amount = rng.nextInt(pile.getCounters()) + 1;
    System.out.println("CPU has taken " + amount + " counters");
    return amount;
  }
}
