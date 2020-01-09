/*

Dominos Pizza has hungry customers waiting in queue. Each unique order ,i, is placed by a customer at time x[i], and the order takes y[i] units of time to complete.
You have information of all n orders, Find the order in which all customers will receive their pizza and print it. 
If two or more orders are completed at same time then sort them by non decreasing order number.

https://practice.geeksforgeeks.org/problems/hungry-pizza-lovers/0

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
		  //  int x[] = new int[n];
		  //  int y[] = new int[n];
		  //  int sum[][] = new int[n][2];
		    
		  //  for(int i=0; i<n; i++){
		  //      x[i] = sc.nextInt();
		  //      y[i] = sc.nextInt();
		      //  sum[i][0] = i;
		      //  sum[i][1] = sc.nextInt();
		  //  }
		    
		    PriorityQueue<Order> pq = new PriorityQueue<Order>(new Order());
		    int x, y;
		    for(int i=0; i<n; i++){
		        x = sc.nextInt();
		        y = sc.nextInt();
		      //  System.out.println("For i = "+i+" "+x+"+"+y+"="+(x+y));
		        pq.add(new Order(i+1, (x+y)));
		    }
		    
		  //  for(Order i:pq){
		  //      System.out.println(i.orderNo + " " + i.orderTime);
		  //  }
		  while(!pq.isEmpty()){
		      Order i = pq.poll();
		      //System.out.println(i.orderNo + " " + i.orderTime);
		      System.out.println(i.orderNo);
		  }
		}
	}
}

class Order implements Comparator<Order>{
    int orderNo;
    int orderTime;
    
    public Order(int orderNo, int orderTime){
        this.orderNo = orderNo;
        this.orderTime = orderTime;
    }
    public Order(){
        
    }
    
    @Override
    public int compare(Order a, Order b){
        if(a.orderTime > b.orderTime){
            return 1;
        }
        else if(b.orderTime > a.orderTime){
            return -1;
        }
        else if(b.orderTime == a.orderTime){
            if(a.orderNo > b.orderNo){
                return 1;
            }
            else if(b.orderNo > a.orderNo){
                return -1;
            }
        }
        return 0;
    }
}
