package com.learnwithted.episode4.hangman.before;

import java.util.Scanner;

public class Hangman {

  /**
   * From: https://raw.githubusercontent.com/kelliet/Hangman/master/src/Main.java
   */
  public static void main(String[] args) {
//        1)	At the start of your application the user
//        will be prompted for the puzzle to be presented
//        to the player. Limit the puzzle to at least 1
//        word and no more than 8.
//        Loop the prompt until the puzzle is valid.
    Scanner scanner = new Scanner(System.in);
    String input = "";
    boolean cont = true;
    String[] input1;

    while (cont) {
      System.out.println("Please enter a word or phrase for hangman.");
      System.out.println("At least one word but no more than 8.");
      input = scanner.nextLine();
      input1 = input.split(" ");
      if (!input.equals("") && input1.length <= 8 && input1.length > 0) {
        cont = false;
      }
    }

//        2)	Once the puzzle is entered display the game. The game display consists of
//        the gallows (for the “Man” we’re trying not to hang), the puzzle itself, and the
//        current collection of letters guessed. The puzzle is displayed with underscores for
//        every letter that needs to be guessed. Spaces, apostrophes, quotation marks and other
//        punctuation should be displayed as normal. Only letters should be concealed.

    //another variable declaration

    String[] hangman = new String[input.length()];
    for (int i = 0; i < input.length(); i++) {
      hangman[i] = populateHangman(Character.toString(input.charAt(i)));
    }
    for (int i = 0; i < hangman.length; i++) {
      System.out.print(hangman[i]);
    }
    System.out.println("");
//        3)	The game is played in rounds. Each round the player may guess a letter,
//        solve the puzzle, or give up. These options should be presented in menu form each
//        time the game display is printed.

    String menu = "";
    String playerGuess = "";
    String[] lettersGuessed = new String[26];
    int count = 0;
    cont = true;
    int wrongAnswer = 0;
    boolean found = false;
    while (cont) {
      System.out.println("Please enter 1 to guess a letter, 2 to solve the puzzle, or 3 to quit.");
      menu = scanner.nextLine();
      if (menu.equals("1")) {
        System.out.println("Please enter the letter");
        playerGuess = scanner.nextLine();
        if (input.contains(playerGuess)) {
          for (int i = 0; i < count; i++) {
            if (lettersGuessed[i].equals(playerGuess))
              found = true;
          }
          if (!found)
            lettersGuessed[count++] = playerGuess;
          for (int i = 0; i < input.length(); i++) {
            if (Character.toString(input.charAt(i)).equals(playerGuess)) {
              hangman[i] = playerGuess;
            }
          }
          for (int i = 0; i < hangman.length; i++) {
            System.out.print(hangman[i]);
          }
          for (String i : lettersGuessed) {
            if (i != null)
              System.out.print(i + " ");
          }
          System.out.println("");
        } else {
          for (int i = 0; i < count; i++) {
            if (lettersGuessed[i].equals(playerGuess))
              found = true;
          }
          if (!found) {
            lettersGuessed[count++] = playerGuess;
            wrongAnswer++;
          }

          System.out.println("   ____");
          System.out.println("   |   |");
          if (wrongAnswer >= 1)
            System.out.println("   |   O");
          if (wrongAnswer >= 2)
            System.out.println("   |   |");
          if (wrongAnswer >= 3)
            System.out.println("   |   |/");
          if (wrongAnswer >= 4)
            System.out.println("   |   \\|/");
          if (wrongAnswer >= 5)
            System.out.println("   |      \\");
          if (wrongAnswer >= 5)
            System.out.println("   |     /\\");
          System.out.println("   |");
          System.out.println("___|___");
        }
      }
    }


//        int menu = 0;
//        String letter = "";
//        int iGuessCount = 0;
//        cont = true;
//        int wrongAnswer = 1;
//        while(cont) {
//            System.out.println("Enter 1 to guess a letter, 2 to solve the puzzle, 3 to quit.");
//            menu = Integer.parseInt(scanner.nextLine());
//            if(menu == 1) {
//                System.out.println("enter a letter");
//                letter = scanner.nextLine();
//                lettersGuessed[iGuessCount] = letter;
//                iGuessCount++;
//
//                if(input.contains(letter)) {
//                    for(int y = 0; y < input.length();y++) {
//                        if(Character.toString(input.charAt(y)).equals(letter)) {
//                            hangman[y] = letter + " ";
//                        }
//                    }
//                    for(int i=0 ; i< hangman.length;i++) {
//                        if(i == hangman.length-1)
//                            System.out.println(hangman[i]);
//                        else
//                            System.out.print(hangman[i]);
//                    }
//                } else {
//                    System.out.println(letter + " in not in the puzzle.");
//                    System.out.println("     ____");
//                    System.out.println("     |   |");
//                    if(wrongAnswer == 1)
//                        System.out.println("     |   O");
//                    System.out.println("     |");
//                    System.out.println("     |");
//                    System.out.println("  /\\");
//                    System.out.println("___________");
//                }
//
//            }
//
//        }
//
  }


  public static String populateHangman(String value) {

    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    if (alphabet.contains(value))
      return "_ ";
    else
      return value;

  }


}
