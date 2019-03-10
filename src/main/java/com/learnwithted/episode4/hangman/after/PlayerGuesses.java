package com.learnwithted.episode4.hangman.after;

import java.util.HashSet;
import java.util.Set;

public class PlayerGuesses {
  private final Set<String> guesses = new HashSet<>();

  public void addGuess(String playerGuess) {
    guesses.add(playerGuess);
  }

  public boolean hasBeenGuessed(String playerGuess) {
    return guesses.contains(playerGuess);
  }

  public void display() {
    guesses.forEach(s -> System.out.print(s + " "));
  }
}
