/*package whatever //do not write package name here */

/*

Given an array arr of size N, containing elements, choose any two elements S1 and S2 in the interval [L, R], where 0 <= L <= R <= N-1 such that Ti = (S1 | (S1 & S2)) ^ (S2 & (S2 | S1)) where |, & and ^ are bitwise OR, AND, XOR operators respectively.
The task is to find the maximum possible value of Ti.

https://practice.geeksforgeeks.org/contest-problem/the-operations/0/

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Operations {
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
			// int a = 9, b = 8;
			// int res1 = (a|(a&b));
			// int res2 = (b&(b|a));
			// System.out.println("res1\n" + res1 + "\nres2\n" + res2);
			// System.out.println(res1^res2);
			int maxVal = 0;
			for (int i=0; i<arrLength; i++) {
				for (int j=i+1; j<arrLength; j++) {
					maxVal = Math.max(maxVal, arr[i] ^ arr[j]);
				}
			}
			System.out.println(maxVal);
			noOfTests--;


		}
	}

}
