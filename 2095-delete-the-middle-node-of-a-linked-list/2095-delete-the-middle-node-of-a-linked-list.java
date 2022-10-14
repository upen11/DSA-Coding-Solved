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

    public ListNode deleteMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        
        // only one element is there [2], return empty/null
        if (head.next == null) {
            return null;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head.next.next;  // we have checked head.next == null condition above
        
        // before checking the loop we have already placed slow and fastPointer on 0th and 2nd index

        while (fastPointer != null && fastPointer.next != null) {   // fastPointer will be null when list is [1, 2]
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        
        slowPointer.next = slowPointer.next.next;

        return head;
    }
}
