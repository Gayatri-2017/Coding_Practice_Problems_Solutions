/*
Given a Binary Tree of N edges. 
The task is to convert this to a Circular Doubly Linked List(CDLL) in-place. 
The left and right pointers in nodes are to be used as previous and next pointers respectively in converted CDLL. 
The order of nodes in CDLL must be same as Inorder of the given Binary Tree. 
The first node of Inorder traversal (left most node in BT) must be head node of the CDLL.

https://practice.geeksforgeeks.org/problems/binary-tree-to-cdll/1
*/

import java.util.Scanner;
import java.util.*;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
    
class TreeNode{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            if(n==0){
                System.out.println(0);
                continue;
            }
            Node root = null;
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0){
                    root=new Node(a);
                    switch(lr){
                        case 'L':root.left=new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }
            //inorder(root);
            GfG g=new GfG();
                 root =  g.bTreeToClist(root);
                
                TreeNode tn = new TreeNode();
                tn.displayCList(root);
                
                
                /* inorder(root);
                 System.out.println();*/
            
        }
    }
    public static void insert(Node root,int a,int a1,char lr){
        if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                break;
                case 'R':root.right=new Node(a1);
                break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    void displayCList(Node head)
{
    Node itr = head;
    do
    {
       System.out.print(itr.data + " ");
        itr = itr.right;
    } while (head!=itr);
   System.out.println();
    itr=itr.left;
    do{
        System.out.print(itr.data + " ");
        itr=itr.left;
    }while(head!=itr);
    System.out.println(itr.data + " ");
}
}
}
/*This is a function problem.You only need to complete the function given below*/
/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/
//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class GfG
{ 
    static ArrayList<Integer> dataList = new ArrayList<Integer>();
    Node bTreeToClist(Node root)
    {
        //your code hereNode prev = null;
        // Node prev = null;
        // Node curr = null;
        // inorder(prev, root);
        dataList.clear();
        inorder(root);
        Node cdllCurrentNode = null;
        // Node cdllNextNode = null;
        Node cdllPrevNode = null;
        //create a cdll
        // for(Integer i : dataList){
        Node cdllHead = new Node(dataList.get(0));
        cdllPrevNode = cdllHead; 
        int i;
        // for(i=1; i<dataList.size()-1; i+=2){
        for(i=1; i<dataList.size(); i+=1){
            cdllCurrentNode = new Node(dataList.get(i));
            // cdllNextNode = new Node(dataList.get(i+1));
            
            cdllPrevNode.right = cdllCurrentNode;
            cdllCurrentNode.left = cdllPrevNode;
            // cdllCurrentNode.right = cdllNextNode;
            // cdllNextNode.left = cdllCurrentNode;
            
            cdllPrevNode = cdllCurrentNode;
        }
        cdllPrevNode.right = cdllHead;
        cdllHead.left = cdllPrevNode;
        
        return cdllHead;
    }
    
    // static void inorder(Node prev, Node root){
    static void inorder(Node root){    
        if(root != null){
            // Node cur = new Node(root.data);
            // inorder(prev, root.left);
            inorder(root.left);
            dataList.add(root.data);
            // prev = root;
            // System.out.println("root.data" + root.data);
            // System.out.println("cur.data" + cur.data);
            // cur.right = root.data;
            inorder(root.right);
        }
    }
}
    
