package com.learnwithted;

import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

  @Test
  public void emptyListIsEmpty() {
    assertThat(Collections.emptyList())
        .isEmpty();
  }
}
