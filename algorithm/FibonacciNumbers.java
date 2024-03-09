/*
 <fibo>
 1 1 2 3 5 8 13 21 34 ...
 An = An-1 + An-2
 a1 = 1, a2 = 1, an ...
 */

import java.util.Arrays;

public class FibonacciNumbers {
	
	public static void main(String[] args) {
		int[] arr = new int[10];
		arr[0] = 1;
		arr[1] = 1;
		
		for (int i = 2; i < 10; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
