package com.learnwithted;

import java.util.Scanner;

/**
 * From https://www.reddit.com/r/javahelp/comments/ar11id/my_table_is_coming_up_with_a_runtime_error_and_im/
 */
public class InterestCalculator {

  public static void main(String args[]) {

    int numberOfQuarters;

    double startingBalance;

    double interestRate;

    double interestEarned;

    double endingBalance;

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

// AND HERES WHERE THE ERROR STARTS, bellow. The equations are right and i believe the for loop is executed right as well, I know that.

    System.out.printf("%20s %20s %20s %20s \n", "Number of Quarters", "Starting Balance", "Interest Earned", "Ending Balance");

    for (int i = 0; i < numberOfQuarters; i++) {

      interestEarned = (startingBalance * (interestRate / 100) * 0.25);

      endingBalance = startingBalance + interestEarned;

      System.out.printf("%2s %10d %10.2f %10.2f \n", numberOfQuarters, startingBalance, interestEarned, endingBalance);

      startingBalance = endingBalance;

    }

  }
}