package tutorial_4;

import java.io.BufferedReader;
import java.io.FileReader;

public class CountLines {

  public static void main(String[] args) {
    long total = 0;

    // reads in file(s) and counts the number of lines in the file(s)
    // filenames can be specified as command line arguments
    try {
      for (int i = 0; i < args.length; i++) {
        BufferedReader in = new BufferedReader(new FileReader(args[i]));
        while (in.readLine() != null) {
          total++;
        }
        in.close();
      }
      System.out.println("Total lines: " + total);
    } catch (Exception e) {
      System.out.println("File(s) not found");
    }
  }
}
