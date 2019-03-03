package com.learnwithted.makeovercandidates.ihunteer;

/**
 * https://www.reddit.com/r/javahelp/comments/arn3hg/accessing_a_private_array_through_another_class/
 */
public class Tuple {
  private String text;
  private int value;

  public Tuple(String t, int v) {
    text = t;
    value = v;
  }

  public String getText() {
    return text;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int newVal) {
    value = newVal;
  }
}
