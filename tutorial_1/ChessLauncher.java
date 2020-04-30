package tutorial_1;

import java.util.Scanner;

public class ChessLauncher {
  public static void main(String args[]) {
    tutorial_1.HighScore scores = new tutorial_1.HighScore();
    Scanner scanner = new Scanner(System.in);
    int choice;
    do {
      System.out.println("\n" +
        "1. Play Chess\n" +
        "2. Exit\n" +
        "\n" +
        "Enter choice: ");
      try {
        choice = scanner.nextInt();
      } catch (Exception e) {
        scanner.nextLine();
        choice = 50;
      }
      switch (choice) {
        case 1:
          tutorial_1.Chess.main(scores);
          break;
        case 2:
          break;
        default:
          System.out.println("Unknown Choice! Please try again!");
      }
    } while (choice != 2);
  }
}
