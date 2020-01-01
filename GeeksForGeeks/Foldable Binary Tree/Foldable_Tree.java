/*

Given a binary tree, check if the tree can be folded or not. A tree can be folded if left and right subtrees of the tree are structure wise same. An empty tree is considered as foldable.

Consider the below trees:
(a) and (b) can be folded.
(c) and (d) cannot be folded.

(a)
       10
     /    \
    7      15
     \    /
      9  11
(b)
        10
       /  \
      7    15
     /      \
    9       11
(c)
        10
       /  \
      7   15
     /    /
    5   11
(d)
         10
       /   \
      7     15
    /  \    /
   9   10  12


https://practice.geeksforgeeks.org/problems/foldable-binary-tree/1

*/



import java.util.*;
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
class Foldable_Tree
{
     public static void insert(Node root,int a,int a1,char lr)
    {
        if(root==null)
        {
            return;
        }
        if(root.data==a)
        {
            switch(lr)
            {
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
    
     public static void main (String[] args) 
    {
         Scanner sc=new Scanner(System.in);
          int t=sc.nextInt();
          
           while(t-->0){
            int n=sc.nextInt();
            if(n==0)
            {
                System.out.println(0);
                continue;
            }
            Node root = null;
            for(int i=0;i<n;i++)
            {
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0)
                {
                    root=new Node(a);
                    switch(lr)
                    {
                        case 'L':root.left=new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                        break;
                    }
                }
                else
                {
                    insert(root,a,a1,lr);
                }
            }
            
            GFG gfg = new GFG();
            boolean val = gfg.isFoldable(root);
            if(val == true)
              System.out.println("Yes");
            else
              System.out.println("No");
           }
    }
    
    public static void mirror(Node node)
    {
        if(node == null)
           return;
        else
        {
            Node temp;
            
            mirror(node.left);
            mirror(node.right);
            
            temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        
    }
}

/*This is a function problem.You only need to complete the function given below*/
/*
node class of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class GFG
{
    static Foldable_Tree obj = new Foldable_Tree();
    
    public static boolean isFoldable(Node root)
    {
        // add your code here
        if(root == null){
            return true;
        }
        return(check(root.left, root.right));
        
    }
    static boolean check(Node rootLeft, Node rootRight){
        if(rootLeft == null && rootRight == null){
            return true;
        }
        else if(rootLeft == null || rootRight == null){
            return false;
        }
        return (check (rootLeft.left, rootRight.right) && 
                check (rootRight.left, rootLeft.right));
        // if((rootLeft.left != null && rootRight.right != null)){
        //     check(rootLeft.left, rootRight.right); 
        // }
        // else if(rootLeft.left != null || rootRight.right != null){
        //     return false;
        // }
        // if((rootRight.left != null && rootLeft.right != null)){
        //     check(rootRight.left, rootLeft.right); 
        // }
        // else if((rootRight.left != null || rootLeft.right != null)){
        //     return false;
        // }
        // return true;
        
        // if((rootLeft.left != null && rootRight.right != null) ||
        //     (rootLeft.left == null && rootRight.right == null)){
        //     return (check(rootLeft.left, rootRight.right) );    
        // }
        
        // if((rootRight.left != null && rootLeft.right != null)
        //     || (rootRight.left == null && rootLeft.right == null)){
        //     return (check(rootRight.left, rootLeft.right) );    
        // }
        
        
        // return false;
        
        // return true;
    }
    
    
}
