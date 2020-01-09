/*
Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, find number of distinct combinations to reach the given score.

https://practice.geeksforgeeks.org/problems/reach-a-given-score/0
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
		    int arr[] = new int[n+1];
		    arr[0]=1;
		  //  count = 0;
		    
		    System.out.println(result(arr, n));
		}
	}
	static int result(int arr[], int n){
	   // for(int i=0; i<10; i++){
	   //     if(i%3 == 0 || i%5 == 0 || i%5==3){
	   //         arr[i]=1;   
	   //     }
	   // }
	    for(int i=3; i<arr.length; i++){
	        arr[i] += arr[i-3];
	       // System.out.println("For i = " + i + " arr[" + i + "] = " + arr[i]);
	       // System.out.println("arr[i-3] = " + arr[i-3]);
	    }
	   for(int i=5; i<arr.length; i++){
	        arr[i] += arr[i-5];
	       // System.out.println("For i = " + i + " arr[" + i + "] = " + arr[i]);
	       // System.out.println("arr[i-5] = " + arr[i-5]);
	    }
	    for(int i=10; i<arr.length; i++){
	        arr[i] += arr[i-10];
	       // System.out.println("For i = " + i + " arr[" + i + "] = " + arr[i]);
	       // System.out.println("arr[i-10] = " + arr[i-10]);
	    }
	   
	    return arr[n];
	}
	
}
