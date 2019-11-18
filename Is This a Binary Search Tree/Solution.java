/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

https://www.hackerrank.com/challenges/is-binary-search-tree/problem

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }

*/
    boolean checkBST(Node root) {
        return myCheckTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }
boolean myCheckTree(Node root, int min, int max){
    if(root == null){
        return true;
    }
    // if(min >= max){
    //     return false;
    // }
    if(root.left == null && root.right == null){
        return true;
    }
    if((root.data < min) || (root.data > max)){
        return false;
    }
    
    
    if(root.data > min && root.data < max){
        // if(root.left != null && root.right != null){
            return myCheckTree(root.left, min, root.data-1) && myCheckTree(root.right, root.data+1, max);
        // }
        // else if(root.left != null){
        //     return myCheckTree(root.left, min, root.data-1);
        // }
        // else if(root.right != null){
        //     return myCheckTree(root.right, root.data+1, max);
        // }
        
    }
    // else{
    //     return false;
    // }
    return false;
    // if(root.left.data<root.data){
    //     return myCheckTree(root.left, min, root.data);
    // }
    // if(root.right.data<root.data){
    //     return myCheckTree(root.left, min, root.data);
    // }
}
