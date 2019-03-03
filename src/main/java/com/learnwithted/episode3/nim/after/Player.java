package com.learnwithted.episode3.nim.after;

import java.util.Random;
import java.util.Scanner;

public abstract class Player {

  private String name;

  public Player(String name) {
    this.name = name;
  }

  public static Player create(String name, Scanner sc, Random rng) {
    if (name.equalsIgnoreCase("cpu")) {
      return new ComputerPlayer(name, rng);
    } else {
      return new HumanPlayer(name, sc);
    }
  }

  public String getName() {
    return name;
  }

  public abstract Pile choosePile(Piles piles);

  public abstract int chooseAmount(Pile pile);
}
