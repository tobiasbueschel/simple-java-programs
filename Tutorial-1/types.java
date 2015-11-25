

/**
 * <dl>
 * <dt>Purpose:
 * <dd>Simple example program
 *
 * <dt>Description:
 * <dd>This program prints out the message Hello World.
 * </dl>
 *
 * @author Tobias Büschel
 * @version $Date: 2015/09/18 12:29:11 $
 *
 */

public class Exercise1_Types {

	public static void main(String[] args) {
		System.out.println("Here are the differences between primitive types");

		int max = Integer.MAX_VALUE; // assigns maximum int value to max
		int min = Integer.MIN_VALUE; // assigns minimum int value to min

		System.out.println("Maximum value of Int: " + max);
		System.out.println("Minimum value of Int: " + min);

		System.out.println("\n");

		double dmax = Double.MAX_VALUE; // assigns maximum double value to dmax
		double dmin = Double.MIN_VALUE; // assigns minimum double value to dmin

		System.out.println("Maximum value of Double: " + dmax);
		System.out.println("Minimum value of Double: " + dmin);

	}

}
