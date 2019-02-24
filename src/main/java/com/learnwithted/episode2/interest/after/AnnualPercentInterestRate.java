package com.learnwithted.episode2.interest.after;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * From "Java Makeover" Episode 2: https://www.twitch.tv/videos/384937583
 */
public class AnnualPercentInterestRate {

  private int rate;
  private BigDecimal rateAsBigDecimal;

  public AnnualPercentInterestRate(int rate) {
    if (rate <= 0 || rate > 20) {
      throw new IllegalArgumentException("Rate must be greater than 0 or less than or equal to 20");
    }
    this.rate = rate;
    this.rateAsBigDecimal = new BigDecimal(rate).divide(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(4));
  }

  public double quarterlyInterestEarnedOn(double balance) {
    return (rate / 100.0) * balance / 4.0;
  }

  public BigDecimal quarterlyInterestEarnedOn(BigDecimal balance) {
    return balance.multiply(rateAsBigDecimal).setScale(2, RoundingMode.HALF_EVEN);
  }
}
