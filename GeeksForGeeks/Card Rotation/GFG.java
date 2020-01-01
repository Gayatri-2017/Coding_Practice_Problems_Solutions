/*
Given a sorted deck of cards numbered 1 to N.

1) We pick up 1 card and put it on the back of the deck.

2) Now, we pick up another card , it turns out to be card numbered 1 , we put it outside the deck.

3) Now we pick up 2 cards and put it on the back of the deck.

4) Now, we pick up another card and it turns out to be card numbered 2 , we put it outside the deck. ...

We perform this step till the last card.

If such arrangement of decks is possible, output the arrangement, if it is not possible for a particular value of N then output -1.

https://practice.geeksforgeeks.org/problems/card-rotation/0

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
		    Queue<Integer> que = new LinkedList<Integer>();
		    for(int i=1; i<n+1; i++){
		        que.add(i);
		    }
		    
		    // System.out.println("Queue is");
		    // for(int i:que){
		    // 	System.out.print(i+" ");
		    // }
		    // System.out.println();

		    int cardArr[] = new int[n];

		    int firstCard = que.poll();
		    que.add(firstCard);

		    int counter = 2;
		    // while(counter < n+1){
		    while(!que.isEmpty()){
		    	// System.out.println("For counter = " + counter + " Queue is");
		    	// for(int i:que){
		    	// 	System.out.print(i+" ");
		    	// }
		    	// System.out.println();

		    	int index = que.poll();
		    	cardArr[index-1] = counter-1;

		    	// System.out.println("For counter = " + counter + " index = " + index + "  cardArr is");
		    	// for (int i=0; i<n; i++) {
		    	// 	System.out.print(cardArr[i] + " ");
		    	// }
		    	// System.out.println();

		    	// if(que.size() > counter){
		    	if(!que.isEmpty()){
		    		for (int i=0; i<counter; i++) {
		    			int card = que.poll();
		    			que.add(card);
		    		}
		    	}
		    	// }
		    	// else{
		    	// 	for (int i=0; i<counter; i++) {
		    	// 		int card = que.poll();
		    	// 		que.add(card);
		    	// 	}
		    	// }
		    	counter++;
		    }

		    if(allNonZeros(cardArr)){
		    	for (int i=0; i<n; i++) {
		    		System.out.print(cardArr[i] + " ");
		    	}
		    	System.out.println();
		    }


		}
	}
	static boolean allNonZeros(int arr[]){
		for (int i=0; i<arr.length; i++) {
			if(arr[i] == 0)
				return false;
		}
		return true;
	}
}
