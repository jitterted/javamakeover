package com.learnwithted.episode3.nim.before;

public class Pile {
  private String name; //	Name of the pile (eg: coins, toothpicks, marbles...)
  private int counters;

  public Pile(String name, int counters) {
    this.name = name;
    this.counters = counters;
  }

  public String getName() {
    return name;
  }

  public int getCounters() {
    return counters;
  }

  public void setCounters(int amount) {
    counters = amount;
  }

  @Override
  public String toString() {
    return name + ": " + counters;
  }
}
