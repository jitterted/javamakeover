package com.learnwithted.episode2.rockpaperscissors.after;

import org.junit.Test;

import static com.learnwithted.episode2.rockpaperscissors.after.Choice.*;
import static org.assertj.core.api.Assertions.assertThat;

public class GameAppTest {

  @Test
  public void lizardBeatsSpock() throws Exception {
    assertThat(LIZARD.against(SPOCK))
        .isEqualTo(1);
  }

  @Test
  public void spockLosesToLizard() throws Exception {
    assertThat(SPOCK.against(LIZARD))
        .isEqualTo(-1);
  }

  @Test
  public void paperBeatsSpock() throws Exception {
    assertThat(PAPER.against(SPOCK))
        .isEqualTo(1);
  }

  @Test
  public void rockCrushesLizard() throws Exception {
    assertThat(ROCK.against(LIZARD))
        .isEqualTo(1);
  }

  @Test
  public void lizardLosesToRock() throws Exception {
    assertThat(LIZARD.against(ROCK))
        .isEqualTo(-1);
  }

  @Test
  public void rockLosesToPaper() throws Exception {
    assertThat(ROCK.against(PAPER))
        .isEqualTo(-1);
  }

  @Test
  public void paperBeatsRock() throws Exception {
    assertThat(PAPER.against(ROCK))
        .isEqualTo(1);
  }

  @Test
  public void rockBeatsScissors() throws Exception {
    assertThat(ROCK.against(SCISSORS))
        .isEqualTo(1);
  }

  @Test
  public void scissorsLosesToRock() throws Exception {
    assertThat(SCISSORS.against(ROCK))
        .isEqualTo(-1);
  }

  @Test
  public void rockTiesWithRock() throws Exception {
    assertThat(ROCK.against(ROCK))
        .isZero();
  }

  @Test
  public void userPaperAndComputerPaperIsTied() throws Exception {
    assertThat(GameApp.determineWinner(PAPER, PAPER))
        .isEqualTo("tie");
  }

  @Test
  public void userPaperBeatsComputerRock() throws Exception {
    assertThat(GameApp.determineWinner(PAPER, ROCK))
        .isEqualTo("you");
  }

  @Test
  public void userRockBeatsComputerScissors() {
    assertThat(GameApp.determineWinner(ROCK, Choice.SCISSORS))
        .isEqualTo("you");
  }

  @Test
  public void userScissorsLosesToComputerRock() throws Exception {
    assertThat(GameApp.determineWinner(Choice.SCISSORS, ROCK))
        .isEqualTo("computer");
  }
}