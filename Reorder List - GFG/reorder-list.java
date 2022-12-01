//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

  public class ReorderList {
    Node head; // head of lisl
    Node last; // last of linked list

    /* Linked list Node*/

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            last = head;
        } else {
            // Node temp = head;
            // while (temp.next != null) temp = temp.next;

            last.next = node;
            last = last.next;
        }
    }
    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ReorderList llist = new ReorderList();

            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            llist.head = new Solution().reorderlist(llist.head);

            llist.printList();

            t--;
        }
    }
}
// } Driver Code Ends


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

class Solution {
    Node reorderlist(Node head) {
        // Your code here
        if(head == null || head.next == null) return head;
        
        Node l1 = head;
        
        // step1: finding middle of the LL
        Node mid = middleElement(head);
        
        Node l2 = mid.next; // l2 will point to second part of LL
        
        mid.next = null; // mid will always be the last element
        
        // step2: reversing the second part of the LL after middle element
        l2 = reversingLL(l2);
        
        // step3: traversing both lists and then reordering it
        while(l2 != null) {
            Node temp1 = l1.next;
            l1.next = l2;
            Node temp2 = l2.next;
            l2.next = temp1;
            l2 = temp2;
            l1 = temp1;
        }
        
        return head;
    }
    
    Node middleElement(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;
        
        while(fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        
        return slowPointer;
    }
    
    Node reversingLL(Node l2) {
        Node prev = null;
        Node nextNode = null;
        Node curr = l2;
        
        while(curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        
        return prev;   // at last curr will point at null and prev to last node
    }
}
