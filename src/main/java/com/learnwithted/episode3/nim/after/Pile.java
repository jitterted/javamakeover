package com.learnwithted.episode3.nim.after;

import java.util.Random;

public class Pile {
  private String name; //	Name of the pile (eg: coins, toothpicks, marbles...)
  private int counters;

  public Pile(String name, Random rng) {
    this.name = name;
    this.counters = rng.nextInt(3) + 3;
  }

  public String getName() {
    return name;
  }

  public int getCounters() {
    return counters;
  }

  @Override
  public String toString() {
    return name + ": " + counters;
  }

  public boolean hasCounters() {
    return counters > 0;
  }

  public boolean hasName(String name) {
    return this.name.equals(name);
  }

  public boolean isCounterValid(String counters) {
    try {
      int n = Integer.parseInt(counters);
      if (n <= 0) {
        System.out.println("You cannot take 0 or less counters. Try again.\n");
        return false;
      } else if (n > getCounters()) {
        System.out.println("You cannot take more counters from a pile than it already has it. Try again.\n");
        return false;
      }
      return true;
    } catch (NumberFormatException e) {
      System.out.println("Invalid number given!\n");
      return false;
    }
  }

  public void removeCounters(int amount) {
    counters -= amount;
  }
}
