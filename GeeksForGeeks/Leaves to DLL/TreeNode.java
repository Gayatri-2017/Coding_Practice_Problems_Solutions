/*
Given a Binary Tree with N edges. 
The task is to extract all leaves of it in a Doubly Linked List (DLL). 

Note that the DLL need to be created in-place. 
Assume that the node structure of DLL and Binary Tree is same, only the meaning of left and right pointers are different. 
In DLL, left means previous pointer and right means next pointer. 
Head of DLL should point to the left most leaf and then in inorder traversal and so on.

https://practice.geeksforgeeks.org/problems/leaves-to-dll/1

*/


import java.util.Scanner;
class Node
{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
class TreeNode
{
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
            Node head = null;
            //inorder(root);
            GfG g=new GfG();
           root = g.convertToDLL(root);
            g.pritntDLL();
            System.out.println();
           
           // System.out.println(g.tilt(root));
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
    // static ArrayList<Integer> dataList = new ArrayList<Integer>();
    Node newHead;
    Node currentNode;
    Node previousNode;
    
    Node convertToDLL(Node root)
    {
        //your code here
        
        inorder(root);
        // System.out.println("ArrayList = " + dataList);
        
        // newHead = new Node(dataList.get(0));
        // newHead.left = null;
        // Node previousNode = newHead;
        // Node currentNode;
        
        // for(int i=1; i<dataList.size(); i++){
        //     currentNode = new Node(dataList.get(i));
        //     currentNode.left = previousNode;
        //     previousNode.right = currentNode;
            
        //     previousNode = currentNode;
        // }
        // currentNode.right = null;
        // pritntDLL();
        return newHead;
    }
    void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            // if(root.left == null && root.right == null){
            //     dataList.add(root.data);
            // }
            
            if(root.left == null && root.right == null){
                if(newHead == null){
                    newHead = new Node(root.data);
                    newHead.left = null;
                    previousNode = newHead;
                }
                else{
                    currentNode = new Node(root.data);
                    currentNode.left = previousNode;
                    previousNode.right = currentNode;
                
                    previousNode = currentNode;
                }
            }
            // System.out.println(root.data);
            inorder(root.right);
        }
        
    }
    
    public void pritntDLL() {
        Node n = newHead ;//head being head of the Dlinkedlist
        Node temp = null;
        while(n!=null) {
            System.out.print(n.data+" ");
            temp = n;
            n = n.right;
        }
        System.out.println();
        while(temp !=null) {
            System.out.print(temp.data+" ");
            temp = temp.left;
        }
    }
        
}
