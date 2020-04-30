package tutorial_3;

import java.util.Scanner;

public class DNAStrandTester {

  public static void summarise(tutorial_3.DNAStrand dna) {
    System.out.println("Original DNA Sequence: " + dna);

    if (dna.isValidDNA()) {
      System.out.println("Is valid");
      System.out.println("Complement: " + dna.complementWC());
      System.out.println("WC Palindrome: " + dna.palindromeWC());
    } else {
      System.out.println("Not Valid DNA");
    }
  }

  public static void main(String[] args) {
    // creates Scanner object & asks user for input
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter DNA sequence: ");
    String dnaInput = sc.nextLine();
    sc.close();

    // creates new DNAStrand object using user String input
    tutorial_3.DNAStrand dna = new tutorial_3.DNAStrand(dnaInput);
    summarise(dna);

    System.out.println("Sequence 'AT' is contained in dna: " + dna.containsSequence("AT"));
  }
}
