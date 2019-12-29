/*package whatever //do not write package name here */

/*

Given an array arr of size n containing only distinct integers, you need to find total times you see a series of consecutive integers of length greater than 1.
A series of consecutive integers is defined as arr[i], arr[i]+1, arr[i]+2...and so on.

https://practice.geeksforgeeks.org/contest-problem/continuous-series/0/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class ContinuousSeries {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int noOfTests = 0;		
		noOfTests = sc.nextInt();
		while(noOfTests>0){
			int arrLength = sc.nextInt();
			int arr[] = new int[arrLength];
			for (int i=0; i<arrLength; i++) {
				arr[i] = sc.nextInt();
			}
			int count = 0;
			boolean prevPair = false;
			for (int i=0; i<arr.length-1; i++) {
				if(arr[i+1]-arr[i] == 1 && prevPair==false){
					count++;
					prevPair=true;
				}
				else if (arr[i+1]-arr[i] != 1){
					prevPair=false;
				}
			}
			// System.out.println("Counter = \n" + count);
			System.out.println(count);
			// for (int i=0; i<arrLength; i++) {
			// 	System.out.print(arr[i] + " ");
			// }
			// System.out.println();
			noOfTests--;
		}

	}
}
