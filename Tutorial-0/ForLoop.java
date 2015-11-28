public class ForLoop {

	public static void main(String[] args) {

		// prints "message" from 0-9
		for (int counter = 0; counter < 10; counter++) {
			System.out.println("message" + counter);
		}
		
		// prints "message" from 9-0
		for (int counter = 9; counter >= 0; counter--) {
			System.out.println("message" + counter);
		}
	}
}
