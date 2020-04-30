package tutorial_4.currency_converter;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
  private Scanner sc;
  ArrayList<Currency> currencies = new ArrayList<Currency>();

  // 1st Step: open the file
  public void openFile() {
    try {
      sc = new Scanner(new File("rates.txt"));
    } catch (Exception e) {
      System.out.println("ERROR: " + e);
    }
  }

  // 2nd Step: read lines from the file and store in ArrayList
  public void readFile() {
    while (sc.hasNext()) {
      currencies.add(new Currency(sc.next(), Double.parseDouble(sc.next())));
    }
    sc.close();
  }

  public void printOut() {
    for (int i = 0; i < currencies.size(); i++) {
      System.out.print(currencies.get(i)
        .getName() + " ");
      System.out.println(currencies.get(i)
        .getRate());
    }
  }

  public int sizeOf() {
    return currencies.size();
  }

  public String getName(int i) {
    return currencies.get(i)
      .getName();
  }

  public double getRate(int i) {
    return currencies.get(i)
      .getRate();
  }
}
