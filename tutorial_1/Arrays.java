package tutorial_1;

/**
 * Demonstrates array initialization and arithmetic.
 *
 * @author Tobias Büschel
 * @version $Date: 2015/09/18 12:29:11 $
 */
public class Arrays {

	public static void main(String[] args) {

		// declares & initializes array with length 20
		int n = 20;
		int numbers[] = new int[n];
		double meanNumbers[] = new double[n];

		// (1) loops through array and initializes i with double the
		// value of the previous element
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				numbers[0] = 1;
			} else {
				numbers[i] = numbers[i - 1] * 2;
			}
		}

		// creates 2nd array - holding the mean of numbers[i-1] and [i+1]
		for (int j = 0; j < n; j++) {
			if (j == 0) {
				meanNumbers[0] = 1;
			}

			else if (j == n - 1) {
				meanNumbers[j] = numbers[j];
			}

			else {
				meanNumbers[j] = (numbers[j - 1] + numbers[j + 1]) / 2.0;
			}
		}

		// prints out both arrays
		for (int x = 0; x < n; x++) {
			System.out.println("1st Array: " + numbers[x] + "\t\t Mean values: " + meanNumbers[x]);
		}
	}
}
