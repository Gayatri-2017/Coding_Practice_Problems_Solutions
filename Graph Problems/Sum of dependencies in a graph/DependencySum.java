/*package whatever //do not write package name here */

/*
Given a directed graph with n nodes. 
If there is an edge from u to v then u depends on v. 
Our task is to find out the sum of dependencies for every node.

https://practice.geeksforgeeks.org/problems/sum-of-dependencies-in-a-graph/0

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class DependencySum {
	public static void main (String[] args) {
		//code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    while(testCases > 0){
			int n = sc.nextInt();
			int e = sc.nextInt();
			// System.out.println("n = " + n + " e = " + e);
			Graph graph = new Graph(n);
			// String inpStr = sc.next();
			// System.out.println(inpStr);
			// String inpArray[] = inpStr.split(" ");
			// for (int i = 0; i < inpArray.length; i++) {
			// 	System.out.println(Integer.parseInt(inpArray[i]));
			// }
			for (int i=0; i<e; i++) {
				graph.addEdge(sc.nextInt(), sc.nextInt());
			}
			System.out.println(graph.findCount(0));
			testCases--;
	    }
	}
}

class Graph{
	int v;
	LinkedList<Integer> adj[];
	Graph(int v){		
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList();	
		}
	}
	void addEdge(int u, int v){
		adj[u].add(v);
	}
	int findCount(int start){
		// return 1;
		int count = 0;
		boolean visited[] = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// visited[start] = true;
		// queue.add(start);

		// while(!queue.isEmpty()){
		// 	int v = queue.poll();
		for (int i=start; i<v; i++) {
			

			Iterator<Integer> li = adj[i].listIterator();
			while(li.hasNext()){

				int liVal = li.next();
				// if(!visited[liVal]){
					// visited[liVal] = true;
					// queue.add(liVal);
					// count++;
				// }
				count++;
			}
		}
		return count;

	}
}
