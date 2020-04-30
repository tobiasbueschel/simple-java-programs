package tutorial_2;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Vectors {

  public static void main(String[] args) {

    // declares and initializes Java Vector
    Scanner sc = new Scanner(System.in);
    Vector<Double> myVector = new Vector<Double>(50);

    double input = 0.0;

    do {
      input = sc.nextDouble();
      if (input == 0) {
        break;
      } else {
        myVector.add(input);
      }
    }
    while (input != 0);
    sc.close();

    System.out.println("Unsorted vector: " + myVector);
    Collections.sort(myVector);
    System.out.println("Sorted vector: " + myVector);

  }
}
