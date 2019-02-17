package com.learnwithted.ihunteer;

/**
 * https://www.reddit.com/r/javahelp/comments/arn3hg/accessing_a_private_array_through_another_class/
 */
public class Use {
  public static Group extract(Group g, int v) {
    int counter = 0;
    Group result = g.copy();

    for (int i = 0; i < result.size(); i++) {
      if (result.map[i].getValue() >= v) {
        result[i] = null;
      }
    }
    return result;
  }
}