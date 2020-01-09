/*

You are given a string of 2N characters consisting of N ‘[‘ brackets and N ‘]’ brackets. 
A string is considered balanced if it can be represented in the for S2[S1] where S1 and S2 are balanced strings. 
We can make an unbalanced string balanced by swapping adjacent characters. 
Calculate the minimum number of swaps necessary to make a string balanced.

https://practice.geeksforgeeks.org/problems/minimum-swaps-for-bracket-balancing/0

*/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		//code
		int countSwap = 0;
		Scanner sc = new Scanner(System.in);
		int noOfCases = sc.nextInt();
		while(noOfCases-- > 0){
		    int len = sc.nextInt();
		    String s1 = sc.next();
		    countSwap = swap(s1);
		    System.out.println(countSwap);
		}
	}
	static int swap(String str){
	    int leftCount=0, rightCount=0, swap=0, imbalance=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='['){
                leftCount++;
                if(imbalance>0){
                    swap+=imbalance;
                    imbalance--;
                }
            }
            else{
                rightCount++;
                imbalance = rightCount-leftCount;
            }
        }
        return swap;
	}
// 	static void swap(String origStr, String str){
// 	    for(int i=0; i<str.length()-1; i++){
// 	        if(str.charAt(i)==']' && str.charAt(i+1)=='['){
// 	            countSwap++;
// 	            str = str.substring(0,i)+'['+']'+str.substring(i+2,str.length());
// 	            System.out.println("For i = " + i + " str = " + str);
// 	            swap(origStr, str);
// 	        }
// 	    }
	    
// 	}
}

/*

Stack based on working solution

Stack<Character> stack = new Stack<Character>();
		    int countSwap = 0;
		    char temp = '\0';
		    for(int i=0; i<s1.length(); i++){
		        char c = s1.charAt(i);
		        
		        if(temp == '\0' && c=='['){
		            stack.push('[');
		        }
		        else if(c==']'){
		            if(!stack.isEmpty()){
		                stack.pop();    
		            }
		            else{
		                temp = c;
		              //  i--;
		            }
		        }
		        else if(temp == ']' && c=='['){
		            countSwap++;
		            temp = '\0';
		        }
		    }

*/
