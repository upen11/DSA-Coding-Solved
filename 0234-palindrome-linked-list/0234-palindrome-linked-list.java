/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // 1 -> 2 -> 2 -> 1
    // 4 -> 3 -> 4
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is at second 2
        // slow is at 3
        ListNode right = reverseLL(slow);
        // After reversing:
        // Left Part:
        // 1 -> 2 -> 2 -> null
        // 4 -> 3 -> null
        
        // Right Part:
        // 1 -> 2 -> null
        // 4 -> 3 -> null
        
        ListNode left = head;
        // very important to keep right != null as condition
        while (right != null) {
            if (left.val != right.val) 
                return false;

            left = left.next;
            right = right.next;
        }

        return true;
    }

    public ListNode reverseLL(ListNode curr) {
        ListNode prev = null;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    
//     public void printLL(ListNode head) {
//         ListNode curr = head;
        
//         while(curr != null) {
//             System.out.print(curr.val + " -> ");
//             curr = curr.next;
//         }
        
//         System.out.println("null");
//     }
}
