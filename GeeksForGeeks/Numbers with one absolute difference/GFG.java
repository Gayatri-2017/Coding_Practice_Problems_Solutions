/*
Given a number N. 
The task is to print all the numbers less than or equal to N in increasing order, 
with the fact that absolute difference between any adjacent digits of number should be 1.

https://practice.geeksforgeeks.org/problems/numbers-with-one-absolute-difference/0

*/
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    // static ArrayList<Integer> arrList = new ArrayList<Integer>();
    static ArrayList<Long> arrList = new ArrayList<Long>();
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int noOfCases = sc.nextInt();
		while(noOfCases-- >0){
		    arrList.clear();
		  //  int n = sc.nextInt();
		    long n = sc.nextLong();
		    if(n<10){
		        System.out.println("-1");
		    }
		    else if(n==10){
		        arrList.add((long)10);
		        printList();
		    }
		    else{
		        for(int i=1; i<10; i++){
		            generateNos((long)i, n);    
		        }
		        printList();
		    }
		}
	}
	
	static void printList(){
	    Collections.sort(arrList);
        // for(Integer arr : arrList){
        for(Long arr : arrList){
            System.out.print(arr + " ");
        }
        System.out.println();
	}
	
// 	static void generateNos(int n, int max){
    static void generateNos(long n, long max){
	   // System.out.println("n = "+ n + "\nmax = " + max);
	    if(n>max){
	        return;
	    }
	    if(n%10 == 0){
	       // int no1 = Integer.parseInt((n + "") + ((n%10)+1 + ""));
	       // long no1 = Integer.parseInt((n + "") + ((n%10)+1 + ""));
	        
            long no1 = Long.parseLong((n + "") + ((n%10)+1 + ""));
            if(no1 > max){
	            return;
	        }
	        
	       // System.out.println(no1 + " ");
	        arrList.add(no1);
	        generateNos(no1, max);
	    }
	    else{
	       // int no1 = Integer.parseInt((n + "") + ((n%10)-1 + ""));
	       // int no2 = Integer.parseInt((n + "") + ((n%10)+1 + ""));
	       // long no1 = Integer.parseInt((n + "") + ((n%10)+1 + ""));
        //     long no2 = Integer.parseInt((n + "") + ((n%10)+1 + ""));
            long no2 = Long.parseLong((n + "") + ((n%10)-1 + ""));
	        if(no2>max){
	            return;
	        }
	       // System.out.println(no1 + " " + no2 + " ");
	        arrList.add(no2);
	        generateNos(no2, max);
	        
            if((n%10)<9){
                long no1 = Long.parseLong((n + "") + ((n%10)+1 + ""));
                if(no1>max){
                    return;
                }
                else{
                    arrList.add(no1);
                    generateNos(no1, max);
                }
            }
            
	    }
	    
	}
}
