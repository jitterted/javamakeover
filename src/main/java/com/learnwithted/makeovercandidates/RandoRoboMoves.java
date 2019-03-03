package com.learnwithted.makeovercandidates;

import java.util.Random;

/**
 * From https://www.reddit.com/r/javahelp/comments/atzzkd/my_robot_is_being_a_bad_boy_and_is_going_out_of/
 */
public class RandoRoboMoves {


  public static void main(String[] args) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
    }

    Random randGen = new Random();


    int[][] maze = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 3},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {2, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    printMaze(maze, randGen);
  }

  public static void printMaze(int[][] maze, Random randGen) {
    final int row = 10;
    final int col = 10;
    int i = 0;
    int j = 0;
    int lastI = 0;
    int lastJ = 0;


    while (maze[3][9] != 5) {


      System.out.println("here");
      final int entRow = 7;
      final int entCol = 0;
      final int exitRow = 2;
      final int exitCol = 9;

      robotMoves(maze, randGen, entRow, entCol, exitRow, exitCol, lastI, lastJ);

      try {
        for (i = 0; i < row; i++) {
          if (maze[i][0] == 2) {
            System.out.print(" E");                  //prints the entrance
          }

          for (j = 0; j < col; j++) {
            if (maze[i][j] == 1) {
              System.out.print(" X");                  //prints the walls
            } else if (maze[i][j] == 0) {

              System.out.print("  ");                  //prints the spaces
            }

            if (maze[i][j] == 5) {
              System.out.print(" R");
              lastI = i;
              lastJ = j;
              maze[i][j] = 0;
            }
          }

          if (maze[i][9] == 3) {
            System.out.print(" E");                      //prints the exit

          }


          System.out.println();
        }
        System.out.println("\n\n\n\n");
        Thread.sleep(100);
      } catch (InterruptedException e) {
      }


    }
    System.out.println("Congratulations! You've reached the end!");


  }

  public static void robotMoves(int[][] maze, Random randGen, int entRow, int entCol, int exitRow, int exitCol, int lastI, int lastJ) {

    int i = 0;
    int j = 0;

    //getting the robot into the maze at the entrance
    if (maze[entRow][entCol] == 2) {
      maze[entRow][entCol] = 5;
      return;
    }

    int[][] locationHolder = new int[10][10];


    int x;
    int y;

    System.out.println(lastI + " " + lastJ);

    x = randGen.nextInt(4);

    while (maze[exitRow][exitCol] != 5) {

      //moves left
      if (x == 0) {

        if (maze[lastI][lastJ - 1] != -1 && maze[lastI][lastJ - 1] == 0) {
          maze[lastI][lastJ - 1] = 5;
          return;
        } else {

          x = randGen.nextInt(4);
        }
      }

      //moves right
      if (x == 1) {

        if (maze[lastI][lastJ + 1] == 0 || maze[lastI][lastJ + 1] == 3) {

          maze[lastI][lastJ + 1] = 5;
          return;
        } else {

          x = randGen.nextInt(4);

        }
      }

      // moves up
      if (x == 2) {

        if (maze[lastI][lastJ] != -1 && maze[lastI - 1][lastJ] == 0) {

          maze[lastI - 1][lastJ] = 5;
          return;
        } else {

          x = randGen.nextInt(4);
        }
      }

      //moves down
      if (x == 3) {

        if (maze[lastI + 1][lastJ] == 0) {

          maze[lastI + 1][lastJ] = 5;
          return;
        } else {

          x = randGen.nextInt(4);

        }
      }

    }
  }
}
