package com.learnwithted.episode2.interest.after;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class InterestCalculatorTest {

  @Test
  public void interestRateCalculatedShouldBeCorrect() throws Exception {
    AnnualPercentInterestRate interestRate = new AnnualPercentInterestRate(4);
    double earned = interestRate.quarterlyInterestEarnedOn(100);

    assertThat(earned)
        .isEqualTo(1);
  }

  @Test
  public void basicCalculationShouldBeCorrect() throws Exception {
    AnnualPercentInterestRate annualPercentInterestRate = new AnnualPercentInterestRate(4);
    BigDecimal endingBalance = InterestCalculator.computeBalance(1, annualPercentInterestRate, BigDecimal.valueOf(100));

    assertThat(endingBalance)
        .isEqualByComparingTo("101");
  }

  @Test
  public void endingBalanceShouldBeFourPercentForFourQuarters() throws Exception {
    AnnualPercentInterestRate annualPercentInterestRate = new AnnualPercentInterestRate(4);
    BigDecimal endingBalance = InterestCalculator.computeBalance(4, annualPercentInterestRate, BigDecimal.valueOf(100));

    assertThat(endingBalance)
        .isEqualByComparingTo("104.06");
  }

}