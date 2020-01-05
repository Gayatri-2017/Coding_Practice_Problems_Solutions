/*
Given a length n, count the number of strings of length n that can be made using ‘a’, ‘b’ and ‘c’ with at-most one ‘b’ and two ‘c’s allowed.

 https://practice.geeksforgeeks.org/problems/count-of-strings-that-can-be-formed-using-a-b-and-c-under-given-constraints/0
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
			int arr[][][] = new int[n+1][2][3];
			for (int i=0; i<arr.length; i++) {
				for (int j=0; j<arr[0].length; j++) {
					for (int k=0; k<arr[0][0].length; k++) {
						arr[i][j][k] = -1;
					}
				}
			}
			System.out.println(createPerm(0, n, arr, 0, 1, 2));
		}
	}
	static int createPerm(int l, int n, int arr[][][], int sum, int b, int c){
// 		System.out.println("n = " + n + " sum = " + sum + " b = " + b + " c = " + c);
		if(arr[l][b][c] != -1){
			sum += arr[l][b][c];
			return arr[l][b][c];
		}
		if(l==n){
			// arr[l] = 1;
			// sum += arr[];
			sum += 1;
			return 1;
		}
		// if(bCount<1 || cCount<1){
		// 	return 0;
		// }
		// if(bCount==0 && cCount==0){
		// 	return 1;
		// }
		int cur=0;
		// if(arr[l] == -1){
			
		if(b>0){
// 			System.out.println("Calling createPerm for l = " + (l+1) + " n = " + n + " sum = " + sum + " b = " + (b-1) + " c = " + c);
			cur += createPerm(l+1, n, arr, sum, b-1, c);
		}
		if(c>0){
// 			System.out.println("Calling createPerm for l = " + (l+1) + " n = " + n + " sum = " + sum + " b = " + b + " c = " + (c-1));
			cur += createPerm(l+1, n, arr, sum, b, c-1);
		}
		if(b>=0 && c>=0){
// 			System.out.println("Calling createPerm for l = " + (l+1) + " n = " + n + " sum = " + sum + " b = " + b + " c = " + c);
			cur += createPerm(l+1, n, arr, sum, b, c);
		}
		arr[l][b][c] = cur;
	
		// else{
		// cur = arr[l];
		// }
// 		System.out.println("Array is");
		// for (int i=0; i<arr.length; i++) {
		// 	System.out.print(arr[i] + " ");
		// }
		// for (int i=0; i<arr.length; i++) {
		// 		for (int j=0; j<arr[0].length; j++) {
		// 			for (int k=0; k<arr[0][0].length; k++) {
		// 				System.out.print(arr[i][j][k] + " ");
		// 			}
		// 			System.out.println();
		// 		}
		// 		System.out.println();
		// 	}
		// System.out.println();
		
		return cur;

	}
}
