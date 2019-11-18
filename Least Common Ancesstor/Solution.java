import java.util.*;
import java.io.*;

/*
One of the possible inputs could be:
6
4 2 7 1 3 6
1 7

where 
1st line denotes number of nodes
2nd line denotes the node values
3rd line denotes 2 nodes whose common ancesstor must be found

And Output must be 
4

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
    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        //Traverse v1 and note down the nodes traversed from root till v1
        // int i = 0;
        // Node cur = new Node(root.data);
        Node cur = root;
        // System.out.println("cur.data" + cur.data);
        ArrayList<Node> al1  = new ArrayList<Node>();
        ArrayList<Node> al2  = new ArrayList<Node>();
        while (cur.data != v1 && cur != null){
        // while(True)
            // System.out.println("i = " + i++);
            // al1.add(cur);
            // System.out.println("cur.data \n" + cur.data);
            // if(v1 <= cur.data && cur.left != null){
            if(v1 < cur.data){
                // System.out.println("Inside if");
                cur = cur.left;
                
                // System.out.println("cur.data after left\n" + cur.data);
            }
            // else if (v1 > cur.data && cur.right != null){
            else if (v1 > cur.data){
                // System.out.println("Inside else");
                cur = cur.right;
                // System.out.println("cur.data after right\n" + cur.data);
            }
            // else{
            //     System.out.println("Exiting loop");
            //     break;

            // }
            // System.out.println("ArrayList1 \n" + al1);
            al1.add(cur);
        }
        // System.out.println("ArrayList1 final\n" + al1);
        cur = root;
        while (cur.data != v2 && cur != null){
            // System.out.println("i = " + i++);
            // al2.add(cur);
            // System.out.println("cur.data \n" + cur.data);
            // if(v1 <= cur.data && cur.left != null){
            if(v2 <= cur.data){
                // System.out.println("Inside if");
                cur = cur.left;
                // System.out.println("cur.data after left\n" + cur.data);
            }
            // else if (v1 > cur.data && cur.right != null){
            else if (v2 > cur.data){
                // System.out.println("Inside else");
                cur = cur.right;
                // System.out.println("cur.data after right\n" + cur.data);
            }
            // else{
            //     System.out.println("Exiting loop");
            //     break;

            // }
            // System.out.println("ArrayList2 \n" + al2);
            al2.add(cur);
        }
        // System.out.println("ArrayList2 final\n" + al2);

        Node parent = root;
        int i, j;
        // System.out.println("Arraylist1 \n" + al1);
        // System.out.println("Arraylist2 \n" + al2);
        for(i = 0, j = 0; i < al1.size() && j < al2.size(); i++, j++){
        // for(int i = al1.size()-1, j = al2.size()-1; i >= 0 && j >= 0; i--, j--){
            if(al1.get(i) == al2.get(j)){
                parent = al1.get(i);
            }
        }
        
        return parent;
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
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }   
}