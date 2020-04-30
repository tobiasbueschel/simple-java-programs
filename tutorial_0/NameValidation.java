package tutorial_0;

import java.util.Scanner;

/**
 * This program prompts user for name until it is entered correctly.
 */
public class NameValidation {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("What is your name?");
    String name = "";

    // prompts user for name; re-prompts if nothing or 1 character have been entered
    while (name.isEmpty() || name.length() < 2) {
      name = sc.nextLine();

      if (name.isEmpty()) {
        System.out.println("Fine, don’t tell me your name. Try again!");
      } else if (name.length() < 2) {
        System.out.println("Not your initial, your name please ;)");
      } else {
        System.out.println("Hello! I thought that your name might be "
          + name + "!");
      }
    }
    sc.close();
  }
}
