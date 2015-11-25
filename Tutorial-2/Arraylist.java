

import java.util.ArrayList;
import java.util.Arrays;


public class Arraylist {
	
	public static void main(String[] args){
		
		int sum = 0;
		
		// declares and initializes ArrayList with 100 random integer values
		ArrayList<Integer> aList = new ArrayList<>();
	
		for (int i = 1; i <= 100; i++){
			aList.add((int) Math.floor(Math.random()*101));
		}
		
		// prints out values in aList
		System.out.println("Random ArrayList: " + aList);
		
		// sums all even numbers in aList
		for (int i = 0; i < aList.size(); i++){
			if ( (aList.get(i) % 2) == 0 ){
				int temp = aList.get(i);				
				sum += temp;
			}
		}
		System.out.println("Here is the sum of aList: " + sum);

		// removes odd elements in aList & adds them back to the end of list
		int j = 0;
		int size = aList.size();
		int oddCounter = 0;
		
		while ( j < size-oddCounter ){
			if ( (aList.get(j) % 2) != 0 ){
				int temp = aList.get(j);

				aList.remove(j);
				aList.add(temp);
				oddCounter++;
			}
				
			else{
				j++;
			}
		}
		System.out.println("Odd elements are now in order: " + aList);
		
		// creates Array of integers out of new aList & prints out values
		Integer[] arr = new Integer[aList.size()];
		
		for (int i = 0; i < aList.size(); i++){
			arr[i] = aList.get(i);
		}
		System.out.println("Array: " + Arrays.toString(arr));
		



	}
	
}
