package com.learnwithted.makeovercandidates.ihunteer;

/**
 * https://www.reddit.com/r/javahelp/comments/arn3hg/accessing_a_private_array_through_another_class/
 */
public class Group {
  private Tuple[] map;

  public Group(int n) {
    map = new Tuple[n];
  }

  public int size() {
    return map.length;
  }

  public Tuple delete(int i) {
    if (i < 0 || i >= size() || map[i] == null) {
      return null;
    }

    String saved = map[i].getText();
    int number = map[i].getValue();
    map[i] = null;

    return new Tuple(saved, number);
  }

  public Group copy() {
    Group result = new Group(size());

    for (int i = 0; i < size(); i++) {
      result.map[i] = this.map[i];
    }
    return result;
  }

  public boolean insert(Tuple p) {
    if (p == null) {
      return false;
    }

    for (int i = 0; i < size(); i++) {
      if (map[i] == null) {
        map[i] = p;
        return true;
      }
    }
    return false;
  }
}