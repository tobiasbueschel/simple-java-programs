package tutorial_1;

/**
 * This program prints out the maximum and minimum values of Integer and Double types.
 *
 * @author Tobias Büschel
 * @version $Date: 2015/09/18 12:29:11 $
 */
public class Types {

  public static void main(String[] args) {
    System.out.println("Here are the differences between primitive types");
    System.out.println("Maximum value of Int: " + Integer.MAX_VALUE);
    System.out.println("Minimum value of Int: " + Integer.MIN_VALUE);

    // Print an empty line
    System.out.println("\n");

    System.out.println("Maximum value of Double: " + Double.MAX_VALUE);
    System.out.println("Minimum value of Double: " + Double.MIN_VALUE);
  }
}
