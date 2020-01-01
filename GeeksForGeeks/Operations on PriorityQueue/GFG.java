/*
Given N integers, your task is to add these elements to the PriorityQueue. 
Also, given M integers, the task is to check if element is present in PriorityQueue. 
If present, print 1 and return the max element of priority queue, and then delete the max element. 
If not present, print -1.

https://practice.geeksforgeeks.org/problems/operations-on-priorityqueue/1

*/


//Initial Template for Java
import java.io.*;
import java.util.*;
//Position this line where user code will be pasted.
// Driver class with driver code
class GFG {
    
    // Driver code
	public static void main (String[] args) {
		
		// Taking input using scanner class
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		while(testcase-- > 0){
		    
		    // Priority Queue with comparator
		    PriorityQueue<Integer> p_queue = new PriorityQueue<Integer>(new Comparator<Integer>() {  
    
                public int compare(Integer w1, Integer w2) {                         
                    return w2.compareTo(w1);
                }      
            });
		    
		    int n = sc.nextInt();
		    
		    // Invoking object of Geeks class
		    Geeks obj = new Geeks();
		    
		    for(int i = 0;i<n;i++){
		        int k = sc.nextInt();
		       obj.insert(p_queue, k);
		    }
		   
		    int x = sc.nextInt();
		    for(int i = 0;i<x;i++){
		        int k = sc.nextInt();
		        boolean f = obj.find(p_queue, k);
		        if(f != false){
		            System.out.println("1");
		            System.out.println(obj.delete(p_queue));
		        }
		        else{
		            System.out.println("-1");
		        }
		    }
		}
	}
}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
// Helper class Geeks to implement 
// insert() and findFrequency()
class Geeks{
    
    // Function to insert element into the queue
    static void insert(PriorityQueue<Integer> q, int k){
        
        // Your code here
        //Just insert k in q
        q.add(k);
    }
    
    // Function to find an element k
    static boolean find(PriorityQueue<Integer> q, int k){
        
        // Your code here
        // If k is in q return true else return false
        Iterator iter = q.iterator();
        while(iter.hasNext()){
            Integer elem = (Integer)iter.next();
            if(elem == k){
                return true;
            }
        }
        return false;
    }
    
    // Function to delete the element from queue
    static int delete(PriorityQueue<Integer> q){
        // Your code here
        //Delete the max element from q. The priority queue property might be useful here
        return(q.poll());
        
    }
    
}
