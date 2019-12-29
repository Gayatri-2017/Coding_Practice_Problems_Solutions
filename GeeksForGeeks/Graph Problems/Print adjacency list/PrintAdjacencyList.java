/*package whatever //do not write package name here */
/*
Given number of edges 'E' and vertices 'V' of a bidirectional graph. 
Your task is to build a graph through adjacency list and print the adjacency list for each vertex.

https://practice.geeksforgeeks.org/problems/print-adjacency-list/0

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class PrintAdjacencyList {
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
			// System.out.println(graph.findCount(0));
			graph.printAdj();
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
		adj[v].add(u);
	}
	// int findCount(int start){
	void printAdj(){
		// return 1;
		// int count = 0;
		boolean visited[] = new boolean[v];
		// String output = new String();
		
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// visited[start] = true;
		// queue.add(start);

		// while(!queue.isEmpty()){
		// 	int v = queue.poll();
		for (int i=0; i<v; i++) {
			// output = "" + i;
			ArrayList<Integer> outputList = new ArrayList<Integer>();
			outputList.add(i);
			Iterator<Integer> li = adj[i].listIterator();
			while(li.hasNext()){
				int liVal = li.next();
				// output = output + liVal;
				outputList.add(liVal);
				// System.out.print(liVal + "->");
				// if(!visited[liVal]){
					// visited[liVal] = true;
					// queue.add(liVal);
					// count++;
				// }
				// count++;
			}
			// for (int j=0; j<output.length()-1; j++) {
			// System.out.println("For i = " + i + " Size = " + outputList.size());
			for (int j=0; j<outputList.size()-1; j++) {
				// System.out.print(output.charAt(j) + "-> ");
				System.out.print(outputList.get(j) + "-> ");
			}
			// System.out.println(output.charAt(output.length()-1));
			System.out.println(outputList.get(outputList.size()-1));
			// output = "";
		}
		// return count;
	}
}
