/*

There are given N ropes of different lengths, we need to connect these ropes into one rope. 
The cost to connect two ropes is equal to sum of their lengths. 
The task is to connect the ropes with minimum cost.

https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes/0/

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
		  
		    int lenArray = sc.nextInt();
		    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		    for (int i=0; i<lenArray; i++) {
		    	pq.add(sc.nextInt());
		    }
		    
		    // System.out.println("PriorityQueue is ");
		  	// for(int i:pq){
		  		// System.out.print(i+" ");
		  	// }
		  	// System.out.println();

		    int curSum = 0;
		    long sum = 0;
		    while(pq.size()>=2){
		    	int len1 = pq.poll();
		    	int len2 = pq.poll();
		    	curSum = len1+len2;
		    	sum += curSum;
		    	// System.out.println("len1 = "+ len1 + " len2 = " + len2 + " curSum = " + curSum);
		    	pq.add(curSum);
		    	// System.out.println("PriorityQueue is ");
		    	// for(int i:pq){
		  			// System.out.print(i+" ");
		  		// }
		  		// System.out.println();
		    }
		    System.out.println(sum);

		  //  int lenArray = sc.nextInt();
		  //  int array[] = new int[lenArray];
		  //  long array[] = new long[lenArray];
		  //  for(int i=0; i<lenArray; i++){
		      //  array[i] = sc.nextInt();
		  //  }
		  //  Arrays.sort(array);
		  //  System.out.println("Sorted array");
		  //  for(int i=0; i<array.length; i++){
		  //      System.out.print(array[i] + " ");
		  //  }
		  //  System.out.println();
		  //  int sum = (lenArray-1)*array[0];
		  //  for(int i=1; i<lenArray; i++){
		  //      sum += (lenArray-i)*array[i];
		  //      System.out.println("For array[i] = " + array[i] + " sum = " + sum);
		  //  }
		  //  System.out.println(sum);
		  //  sum = 0;
		    
		  //  long sum1 = array[0];
		  //  array[0] = 0;
		  //  for(int i=1; i<lenArray; i++){
		      //  sum1 += array[i];
		      //  array[i] = sum1;
		        
		  //  }
		  //  sum1 = 0;
		  //  System.out.println("Array is");
		  //  for(int i=0; i<array.length; i++){
		      //  System.out.print(array[i]+" ");
		      //  sum1 += array[i];
		  //  }
		    
		  //  System.out.println();
		  //  System.out.println(sum1);
		  //  sum1=0;
		}
	}
}
