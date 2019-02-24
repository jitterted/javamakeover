package com.learnwithted.episode2.interest.after;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Originally from https://www.reddit.com/r/javahelp/comments/ar11id/my_table_is_coming_up_with_a_runtime_error_and_im/
 *
 * Partially refactored in "Java Makeover" Episode 2: https://www.twitch.tv/videos/384937583
 */
public class InterestCalculator {

  public static void main(String args[]) {

    int numberOfQuarters;
    double startingBalance;
    double interestRate;
    char correct;

    Scanner scnr = new Scanner(System.in);

    do {
      System.out.println("Enter number of quarters from 1 to 10: ");
      numberOfQuarters = scnr.nextInt();

      while ((numberOfQuarters < 1) || (numberOfQuarters > 10)) {
        System.out.println("Invalid.");
        System.out.println("Enter number of quarters from 1 to 10: ");
        numberOfQuarters = scnr.nextInt();
      }

      System.out.println("Enter the beginning principle balance greater than 0: ");
      startingBalance = scnr.nextDouble();

      while (startingBalance < 0.00) {
        System.out.println("Invalid.");
        System.out.println("Enter the beginning principle balance greater than 0: ");
        startingBalance = scnr.nextDouble();
      }

      System.out.println("Enter the interest rate percentage without the percent sign, greater than 0% and less than or equal to 20%: ");
      interestRate = scnr.nextDouble();

      while ((interestRate < 0.00) || (interestRate > 20.00)) {
        System.out.println("Invalid.");
        System.out.println("Enter the interest rate percentage without the percent sign, greater than 0% and less than or equal to 20%:");
        interestRate = scnr.nextDouble();
      }

      interestRate = interestRate / 100;

      System.out.println("You entered a principle balance of $" + startingBalance + " for " + numberOfQuarters + " quarters, at a " + interestRate + "% interest rate.");
      System.out.println("Is this correct? (y/n)");
      correct = scnr.next().charAt(0);

      if (correct == 'y') {
        break;
      } else {
        System.out.println("Please re-enter your information.");
      }

    } while (correct == 'n');

    System.out.printf("%20s %20s %20s %20s \n", "Number of Quarters", "Starting Balance", "Interest Earned", "Ending Balance");

    // ---------------  ^^ ADAPTER   vv  DOMAIN CORE

//    double endingBalance = computeBalance(numberOfQuarters, startingBalance, interestRate);
//    System.out.println("Ending Balance:" + endingBalance);

  }

  public static BigDecimal computeBalance(int numberOfQuarters, AnnualPercentInterestRate interestRate, BigDecimal balance) {
    for (int i = 0; i < numberOfQuarters; i++) {
      balance = balance.add(interestRate.quarterlyInterestEarnedOn(balance));
    }
    return balance;
  }
}