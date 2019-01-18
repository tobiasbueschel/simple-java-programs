package tutorial_2;

import java.util.Scanner;

public class IntEven {

	/**
	* Returns true if given integer is even, false otherwise * @param number
	*/
	public static boolean isEven (int number) {
		// boolean isEven = (number % 2 == 0) ? true : false;
		// return isEven;
		return (number % 2 == 0);
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		System.out.println(isEven(num));
	}
}
