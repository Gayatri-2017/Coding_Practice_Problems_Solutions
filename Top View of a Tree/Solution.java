import java.util.*;
import java.io.*;
/*
One of the possible inputs could be:
6
1 2 5 3 6 4

where 1st line denotes number of nodes and the 
2nd line denotes the node values

And output must be 1 2 5 6
*/

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    static class NodeHgt{
        Node node;
        int hgt;
        NodeHgt(Node node, int hgt){
            this.node = node;
            this.hgt = hgt;
        }
    }
	public static void topView(Node root) {
      
      Queue<NodeHgt> que = new LinkedList<NodeHgt>();
      HashMap<Integer, Node> hgtHash = new HashMap<Integer, Node>();
      Node cur = root;
      int h = 0;
      NodeHgt queHead;
      que.add(new NodeHgt(cur,h));
      while(!que.isEmpty()){
        queHead = que.poll();
        cur = queHead.node;
        h = queHead.hgt;
        if(cur.left != null){
            que.add(new NodeHgt(cur.left, h-1));
        }
        if (cur.right != null){
            que.add(new NodeHgt(cur.right, h+1));
        }
        //   System.out.println("cur.data\n" + cur.data);
        if(!hgtHash.containsKey(h)){
            System.out.print(cur.data + " ");
            hgtHash.put(h, cur);
        }
      }  
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}