package tutorial_2;

import tutorial_1.Methods;

import java.util.Scanner;

public class PascalTriangle {

  public static void printPascalTriangle(int numRows) {

    // prints empty spaces so that triangle shape is formed
    for (int i = 0; i < numRows; i++) {
      long number = 0;
      System.out.format("%" + (numRows - i) * 2 + "s", "");

      // computes column number using factorial method
      for (int j = 0; j <= i; j++) {
        number = Methods.factorial(i) / (Methods.factorial(j) * Methods.factorial(i - j));
        System.out.format("%4d", number);
      }
      System.out.println();
    }

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("How many rows?");
    int rows = sc.nextInt();
    sc.close();

    printPascalTriangle(rows);
  }
}
