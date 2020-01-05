/*
Imagine you have a special keyboard with the following keys: 
Key 1:  Prints 'A' on screen
Key 2: (Ctrl-A): Select screen
Key 3: (Ctrl-C): Copy selection to buffer
Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed. 

If you can only press the keyboard for N times (with the above four keys), write a program to produce maximum numbers of A's. 
That is to say, the input parameter is N (No. of keys that you can press), the output is M (No. of As that you can produce).

https://practice.geeksforgeeks.org/problems/special-keyboard/0

*/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int noOfCases = sc.nextInt();
		while(noOfCases-- >0){
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i=0; i<arr.length; i++) {
				arr[i] = -1;
			}
			// System.out.println("max value = " + maxA(arr, n));
			System.out.println(maxA(arr, n));
		}
	}
	static int maxA(int arr[], int n){
		if(n<7){
			arr[n-1] = n;
			// return n;
		}
		else{
			int multiplier = 2;
			int maxAsOfNow = 0;
			int finalMax = 0;
			for (int i=n-3; i>0; i--) {
				if(arr[i-1] == -1){
					maxAsOfNow = maxA(arr, i)*multiplier;
				}
				else{
					maxAsOfNow = arr[i-1]*multiplier;
				}
				multiplier+=1;
				if(maxAsOfNow > finalMax){
					finalMax = maxAsOfNow;
				}
				arr[n-1] = finalMax;
			}
		}
		// System.out.println("n = "+n+"\narr =");
		// for (int i=0; i<arr.length; i++) {
		// 	System.out.print(arr[i] + " ");
		// }
		// System.out.println();

		return arr[n-1];
	}
}
