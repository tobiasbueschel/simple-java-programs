

import java.util.Scanner;
import Tutorial1.src.Exercise2_Methods;

public class PascalTriangle {
	
	public static void printPascalTriangle(int numRows) {	
		Exercise2_Methods m = new Exercise2_Methods();
		
		// prints empty spaces so that triangle shape is formed
		for (int i = 0; i < numRows; i++) {
			long number = 0;
			System.out.format("%" + (numRows - i) * 2 + "s", "");
			
			// computes column number using factorial method
			for (int j = 0; j <= i; j++) {
				number = m.factorial(i) / (m.factorial(j) * m.factorial(i-j) );
				System.out.format("%4d", number);
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("How many rows?");
		int rows = sc.nextInt();

		printPascalTriangle(rows);
	}

}
