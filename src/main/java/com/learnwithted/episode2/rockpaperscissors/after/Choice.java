package com.learnwithted.episode2.rockpaperscissors.after;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the code after adding Lizard & Spock to the game
 * Featured in Episode 2 of Java Makeover: https://www.twitch.tv/videos/384937583
 */
public enum Choice {
  ROCK, // beats scissors, lizard
  PAPER, // beats rock, spock
  SCISSORS, // paper, lizard
  LIZARD, // paper, spock
  SPOCK; // rock, scissor

  private static Map<Choice, List<Choice>> RULES_MAP = new HashMap<>();

  static {
    RULES_MAP.put(ROCK, Arrays.asList(SCISSORS, LIZARD));
    RULES_MAP.put(PAPER, Arrays.asList(ROCK, SPOCK));
    RULES_MAP.put(SCISSORS, Arrays.asList(PAPER, LIZARD));
    RULES_MAP.put(LIZARD, Arrays.asList(PAPER, SPOCK));
    RULES_MAP.put(SPOCK, Arrays.asList(ROCK, SCISSORS));
  }

  public int against(Choice other) {
    List<Choice> weBeat = RULES_MAP.get(this);
    if (weBeat.contains(other)) {
      return 1;
    } else if (this == other) {
      return 0;
    } else {
      return -1;
    }
  }

}
