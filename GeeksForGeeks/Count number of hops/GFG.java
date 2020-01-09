/*

A frog jumps either 1, 2 or 3 steps to go to top. In how many ways can it reach the top.

https://practice.geeksforgeeks.org/problems/count-number-of-hops/0
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
		while(noOfCases-- > 0){
		   int n = sc.nextInt();
		   System.out.println(computeSteps(n));
		}
	}
	static int computeSteps(int n){
	    int arr[] = new int[n+1];
	    if(n==0||n==1){
	        return 1;
	    }
	    if(n==2){
	        return 2;
	    }
	    if(n>2){
	        arr[0] = 1;
    	    arr[1] = 1;
    	    arr[2] = 2;
    	    for(int i=3; i<arr.length; i++){
    	        arr[i] = arr[i-1]+arr[i-2]+arr[i-3]; 
	        }
	    }
	    return arr[n];
	}
}
