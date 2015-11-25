

import java.util.Scanner;

public class IntEven {

	/**
	* Returns true if given integer is even, false otherwise * @param number
	* @return
	*/
	public static boolean isEven (int number) {
		// boolean isEven = (number % 2 == 0) ? true : false;
		// return isEven;
		return (number % 2 == 0);
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		System.out.println(isEven(num));		
	}
}
