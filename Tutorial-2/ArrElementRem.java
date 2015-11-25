

import java.util.Arrays;

public class ArrElementRem {
	
	public static String[] remElement(String[] arr, int n){
		
		String[] arr2 = new String[arr.length - 1];
		int temp = 0;
		
		for ( int i = 0; i < arr.length-1; i++ ){
			if (i == (n - 1)){
				arr2[i] = arr[n];
				temp++;
			}
			else if(i != (n - 1) ){
				arr2[i] = arr[i+temp];
			}
		}
		
		return arr2;
	}

	public static void main(String[] args){
		String[] arr = {"The ", "quick ", "brown ", "fox ", "jumps ", "over ", "the ", "lazy ", "dog."};
		
		System.out.println(Arrays.toString(arr));
		arr = remElement(arr, 5);
		System.out.println(Arrays.toString(arr));
	}
	
}
