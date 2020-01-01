/*

Given a singly linked list: A_0→A_1→…→A_(n-1)→A_n, reorder it to: A_0→A_n→A_1→A_(n-1)→A_2→A_(n-2)→…
For example: Given 1->2->3->4->5 its reorder is 1->5->2->4->3.

Note: It is recommended do this in-place without altering the nodes' values.

https://practice.geeksforgeeks.org/problems/reorder-list/1


*/

import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
	
public class ReorderList
{
    Node head;  // head of lisl
  
    /* Linked list Node*/
   
                    
    /* Utility functions */
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } 
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
     }
  /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
 
     /* Drier program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			ReorderList llist = new ReorderList();
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt(); 
                llist.addToTheLast(new Node(a));
             }
         
            llist.head = new gfg().reorderlist(llist.head);
            
    		llist.printList();
    		
            t--;
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
/* Following is the Linked list node structure */
/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}*/
	
class gfg
{
    Node reorderlist(Node head)
    {
        // Your code here
        
        //Reach the middle element
        if(head.next == null)
            return head;
        Node lastNode = head;
        Node midNode = head;
        boolean isEven = false;
        while(lastNode.next != null && lastNode.next.next != null){
            // System.out.println("Inside while loop");
            lastNode = lastNode.next.next;
            midNode = midNode.next;
        }

        //for even no of elements
        if(lastNode.next != null){
            lastNode = lastNode.next;
            isEven = true;
        }

        // System.out.println("Last node\n" + lastNode.data);
        // System.out.println("Middle node\n" + midNode.data);

        //Reverse the nodes after the middle node
        Node midTraverseNode = midNode.next;
        Node prevNode = null;
        Node nextNode = null;
        while(midTraverseNode.next != null){
            nextNode = midTraverseNode.next;
            midTraverseNode.next = prevNode;
            prevNode = midTraverseNode;
            midTraverseNode = nextNode;
            // System.out.println("midTraverseNode:\n"+midTraverseNode.data+"\nprevNode:\n"+prevNode.data+"\nnextNode:\n"+nextNode.data);

        }
        midTraverseNode.next = prevNode;
        midNode.next = midTraverseNode;

        // For printing the LinkedList
        // System.out.println("New LinkedList");
        // Node traverseNode = head;
        // while(traverseNode.next != null){
        //     System.out.print(traverseNode.data + "->");
        //     traverseNode = traverseNode.next;
        // }
        // System.out.println(traverseNode.data);
        
        //Reorder LinkedList
        Node head1 = head;
        Node head2 = midNode.next;
        Node head1Next = null;
        Node head2Next = null;

        while(head2.next != null){
            head1Next = head1.next;
            head2Next = head2.next;
            
            head1.next = head2;
            head2.next = head1Next;
            
            head1 = head1Next;
            head2 = head2Next;
        }
        head1.next = head2;
        if(!isEven){
            head2.next = midNode;
            midNode.next = null;
        }
        else{
            head2.next = null;
        }
        // For printing the LinkedList
        // System.out.println("New LinkedList");
        // Node traverseNode = head;
        // while(traverseNode.next != null){
        //     System.out.print(traverseNode.data + "->");
        //     traverseNode = traverseNode.next;
        // }
        // System.out.println(traverseNode.data);

        return head;
    }
}
