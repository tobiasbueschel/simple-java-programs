

import java.util.Arrays;
import java.util.Scanner;


/**
 * <dl>
 * <dt>Purpose:
 * <dd>
 *
 * <dt>Description:
 * <dd>Converts bits into bytes, kilobytes, megabytes, gigabytes etc.
 * </dl>
 *
 * @author Tobias Büschel
 * @version $Date: 2015/10/08 12:29:11 $
 *
 */

public class Exercise4_ByteConversion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double x = sc.nextDouble();
		byteConverter(x);
	}
	
	public static double byteConverter(double a){
		double root = 10.0;
		
		final String[] UNITS = {"B", "KB", "MB", "GB"};
		double[] values = new double[4];
		values[0] = a;
		double temp = a;
		System.out.println(values[0]);
		
		// TODO method should return string?!
		for (int i = 1; i < values.length; i++){
			temp = a / (Math.pow(2.0, root));
			values[i] = temp;
			root += 10.0;
			System.out.println( values[i] + " " + UNITS[i] );
		}
		
		return 0;
	
//		1 Kilobyte = 1,024 Bytes
//		1 Megabyte = 1,048,576 Bytes
//		1 Gigabyte = 1,073,741,824 Bytes
//		1 Terabyte = 1,099,511,627,776 Bytes
		
	}
	
}
	
