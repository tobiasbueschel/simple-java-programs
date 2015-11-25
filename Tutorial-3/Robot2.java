

import java.util.Random;

public class Robot2 extends Robot1 {
	private String[] sayings = null;
	
	// stores message in robot
	public void setSayings(String[] a){
		this.sayings = a;
	}
	
	// speaks message stored in robot
	public void speak(){
		Random rand = new Random();
		int max = this.sayings.length;
		int num = rand.nextInt(max);
		System.out.println( this.sayings[num] );
	}
	
	
	public static void main(String[] args) {
		
		// ROBOT 1
		Robot2 r1 = new Robot2();
		String[] u1 = { "Exterminate, Exterminate!", "I obey!", "You cannot escape.", "Robots do not feel fear.", "The Robots must survive!" };
		r1.setSayings(u1); System.out.println("\nRobot r1 says: ");
		for (int i = 0; i < 10; i++) { 
			r1.speak();
		}
		
		// ROBOT 2
		System.out.println("\nRobot r2 says: ");
		Robot2 r2 = new Robot2(); String[] u2 = { "I obey!" };
		r2.setSayings(u2);
		for (int i = 0; i < 10; i++) {
			r2.speak();
		}

	}
}
