package com.learnwithted.episode3.nim.after;

import java.util.Arrays;
import java.util.Random;

public class Piles {
  private Pile[] piles = new Pile[3];
  private boolean isColumnDisplayMode;  // true for column display, false for numerical

  public Piles(boolean isColumnDisplayMode, Random rng) {
    this.isColumnDisplayMode = isColumnDisplayMode;
    piles[0] = new Pile("A", rng);
    piles[1] = new Pile("B", rng);
    piles[2] = new Pile("C", rng);
  }

  public void display() {
    if (isColumnDisplayMode) {
      displayPilesColumn();
    } else {
      displayPilesNumerical();
    }
    System.out.println();
  }

  public int totalCounters() {
    int total = 0;
    for (Pile i : piles)
      total += i.getCounters();
    return total;
  }

  public void displayPilesNumerical() {
    System.out.printf("%n%s%15s%15s%n", piles[0], piles[1], piles[2]);
  }

  private void displayPilesColumn() {
    int highest = Arrays.stream(piles)
                        .mapToInt(Pile::getCounters)
                        .max()
                        .getAsInt();
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

  public Pile getPile(String name) {
    for (Pile pile : piles) {
      if (pile.hasName(name)) {
        return pile;
      }
    }
    throw new IllegalArgumentException("Name " + name + " is not a known Pile name");
  }


  public String[] allNames() {
    return new String[]{
        piles[0].getName(),
        piles[1].getName(),
        piles[2].getName()};
  }

  //	Validation methods, used to check if player's input is correct
  public boolean isPileValid(String name) {
    Pile pile = getPile(name);

    if (pile != null) {
      if (pile.hasCounters()) {
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

  public boolean hasCounters() {
    return totalCounters() > 0;
  }

  public boolean isEmpty() {
    return totalCounters() == 0;
  }

  public boolean isGameOver() {
    return totalCounters() == 1;
  }
}
