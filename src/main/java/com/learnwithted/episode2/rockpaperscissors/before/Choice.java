package com.learnwithted.episode2.rockpaperscissors.before;

/**
 * This is the code from the completion of Episode 1 of Java Makeover: https://www.twitch.tv/videos/382302523
 * It was the starting point before the additional work done in Episode 2.
 */
public enum Choice {
  ROCK,
  PAPER,
  SCISSORS;

  public int against(Choice other) {
    Choice self = this;

    int comparison = self.compareTo(other);
    if (comparison == -2) {
      return 1;
    } else if (comparison == 2) {
      return -1;
    }
    return comparison;
  }

}
