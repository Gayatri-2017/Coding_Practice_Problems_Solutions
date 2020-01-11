/*

Given an input stream of N integers. 
The task is to insert these numbers into a new stream and find the median of the stream formed by each insertion of X to the new stream.

https://practice.geeksforgeeks.org/problems/find-median-in-a-stream/0

*/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int noOfCases = sc.nextInt();
        int count = 0;
        PriorityQueue<Integer> lowerHalf = new PriorityQueue<Integer>(new maxComparator());
        PriorityQueue<Integer> upperHalf = new PriorityQueue<Integer>();
            
        while(noOfCases-- > 0){
            int n=sc.nextInt();
            addElement(n, lowerHalf, upperHalf);
            rebalance(lowerHalf, upperHalf);
            System.out.println(getMedian(lowerHalf, upperHalf));
        }
    }
    
    static void addElement(int n, PriorityQueue<Integer> lowerHalf, PriorityQueue<Integer> upperHalf){
        if(lowerHalf.size() == 0 || n<lowerHalf.peek()){
            lowerHalf.add(n);
        }    
        else{
            upperHalf.add(n);
        }
    }
    
    static void rebalance(PriorityQueue<Integer> lowerHalf, PriorityQueue<Integer> upperHalf){
        
        PriorityQueue<Integer> biggerHeap = lowerHalf.size() > upperHalf.size() ? lowerHalf : upperHalf;
        PriorityQueue<Integer> smallerHeap = lowerHalf.size() > upperHalf.size() ? upperHalf : lowerHalf;
        
        if(biggerHeap.size()-smallerHeap.size() >=2){
            smallerHeap.add(biggerHeap.poll());
        }
    }
    
    static int getMedian(PriorityQueue<Integer> lowerHalf, PriorityQueue<Integer> upperHalf){
        
        if(lowerHalf.size()==upperHalf.size()){
            return ((lowerHalf.peek()+upperHalf.peek())/2);
        }
        else{
            PriorityQueue<Integer> biggerHeap = lowerHalf.size() > upperHalf.size() ? lowerHalf : upperHalf;
            PriorityQueue<Integer> smallerHeap = lowerHalf.size() > upperHalf.size() ? upperHalf : lowerHalf;
            
            return(biggerHeap.peek());
        }
    }
}


class maxComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer a, Integer b){
        return(-1*a.compareTo(b));
    }
}
// Time limit exceeding code

// class GFG {
// 	public static void main (String[] args) {
// 		Scanner sc = new Scanner(System.in);
// 		int noOfCases = sc.nextInt();
// 		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
// 		while(noOfCases-- > 0){
// 		    int n = sc.nextInt();
// 		    pq1.add(n);
// 		    PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(pq1);
// 		    int i = 0;
// 		    if(pq1.size()%2 == 1){
// 		        int half = (pq1.size()/2);
// 		        while(i < half){
//     		        pq1.poll();
//     		        i++;
//     		    }
//     		    System.out.println(pq1.poll());    
// 		    }
// 		    else if(pq1.size()%2 == 0){
// 		        int half = (pq1.size()/2)-1; 
// 		        while(i < half){
//     		        pq1.poll();
//     		        i++;
//     		    }
//     		    System.out.println((pq1.poll()+pq1.poll())/2);    
// 		    }
// 		    pq1 = new PriorityQueue<Integer>(pq2);
// 		}
// 	}
// }
