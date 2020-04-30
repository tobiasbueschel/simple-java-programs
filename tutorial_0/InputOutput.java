package tutorial_0;

import java.util.Scanner;

/**
 * This program asks the user for first and last name and prints them out.
 */
public class InputOutput {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("What is your first name?");

    // save user’s input in a String variable called ’firstName’
    String firstName = scanner.nextLine();

    // save user’s input in a String variable called ’lastName’
    System.out.println("What is your last name?");
    String lastName = scanner.nextLine();

    // close scanner
    scanner.close();

    // print welcome message on screen including the saved input
    System.out.println("Hello! I think your name might be: "
      + firstName + " " + lastName + "!");
  }
}
