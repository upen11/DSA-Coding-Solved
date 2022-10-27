//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    public static Node reverse(Node node, int k)
    {
        //Your code here
        if(node == null || k == 1) {
            return node;
        }
        
        Node dummy = new Node(-1);
        dummy.next = node;
        Node currNode = node;
        
        Node prev = dummy;
        Node nextNode = currNode.next;
        
        while(nextNode != null) {
            
            currNode = prev.next;
            nextNode = currNode.next;   // here nextNode can be null
            
            // k-1 operations (like swapping of 2 numbers takes 1 operation)
            for(int i=1; nextNode != null && i<k; i++) {
                
                currNode.next = nextNode.next;
                nextNode.next = prev.next;
                prev.next = nextNode;
                nextNode = currNode.next;
                
                // if(nextNode == null) {
                //     break;
                // }
            }
            
            // currNode always points to the first node of the list before reversing 
            prev = currNode;
        }
        
        return dummy.next;
    }
}

