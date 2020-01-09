/*

There are N stairs, and a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does not matter).
Note: Order does not matter means for n=4 {1 2 1},{2 1 1},{1 1 2} are considered same.

https://practice.geeksforgeeks.org/problems/count-ways-to-nth-stairorder-does-not-matter/0/

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
		    //Dynamic Solution
		    System.out.println(result(n));
		    //Mathematical way
		  //  System.out.println(result1(n));
		}
	}
	static int result1(int n){
	    if(n%2==0){
	        return ((n/2) + 1);
	    }
	    else{
	        return((n-1)/2 + 1);
	    }
	}
	static int result(int n){
	    int arr[] = new int[n+1];
	    if(n==0||n==1){
	        return 1;
	    }
	    if(n>=2){
	        arr[0] = 1;
    	    arr[1] = 1;
    	    for(int i=2; i<arr.length; i++){
    	        if(i%2==0){
    	            arr[i] = arr[i-1]+1;    
    	        }
    	        else{
    	            arr[i] = arr[i-1];    
    	        }
    	    }
	    }
	    return arr[n];
	}
}
