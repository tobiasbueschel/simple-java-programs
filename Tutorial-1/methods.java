

import java.util.Scanner;

/**
 * <dl>
 * <dt>Purpose:
 * <dd>Simple calculator program
 *
 * <dt>Description:
 * <dd>Simple calculator that performs addition, subtraction, division, multiplication
 * <dd>and factorial
 * </dl>
 *
 * @author Tobias Büschel
 * @version $Date: 2015/09/18 12:29:11 $
 *
 */

public class Exercise2_Methods {

	public static void main(String[] args) {

		// creates Scanner object
		Scanner sc = new Scanner(System.in);

		// declare and initialize variables
		int operator = 0;
		double op1 = 0.0;
		double op2 = 0.0;
		int factorial = 0;
		double result = 0.0;

		System.out.println("Simple calculator. Please choose an operation:");
		System.out
				.println("1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Factorial\n6. Exit");

		// prompts user to choose function
		while (operator <= 0 || operator > 6) {
			operator = sc.nextInt();
			if (operator == 6) {
				System.exit(1);
			}
		}

		if (operator != 5) {
			System.out.println("Thank you. Please enter two operands: ");
			System.out.println("Operand 1: ");
			op1 = sc.nextDouble();
			System.out.println("Operand 2: ");
			op2 = sc.nextDouble();
		} else {
			System.out.println("Please enter a positive natural number: ");
			factorial = sc.nextInt();
		}

		switch (operator) {

		case 1:
			result = add(op1, op2);
			break;

		case 2:
			result = subtract(op1, op2);
			break;

		case 3:
			result = multiply(op1, op2);
			break;

		case 4:
			result = divide(op1, op2);
			break;

		case 5:
			result = factorial(factorial);
			System.out.println(factorial + "! Factorial is: " + (int) result);
			System.exit(1);

		default:
			System.exit(1);
		}

		System.out.println("The result is: " + result);
	}

	/*
	 * Methods that perform basic arithmetic such as addition, subtraction,
	 * division and multiplication
	 */

	public static double add(double a, double b) {
		double temp = a + b;
		return temp;
	}

	public static double subtract(double a, double b) {
		double temp = a - b;
		return temp;
	}

	public static double multiply(double a, double b) {
		double temp = a * b;
		return temp;
	}

	public static double divide(double a, double b) {
		double temp = a / b;
		return temp;
	}

	public static long factorial(int a) {
		if (a <= 0 || a == 1) {
			return (1);
		} else {
			long temp = factorial(a - 1) * a;
			return temp;
		}
	}

}
