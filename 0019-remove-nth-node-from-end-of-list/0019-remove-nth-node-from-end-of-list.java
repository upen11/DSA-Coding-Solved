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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // if only one element is there there so it will only be deleted making list null
        if(head == null || head.next == null) return null;
        
        ListNode p2 = head;
        
        for(int i=0; i<n; i++) {
            p2 = p2.next;
        }

        // this means n == number of nodes, so first node is to be deleted
        if (p2 == null) return head.next;

        ListNode p1 = head;
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p1.next = p1.next.next;

        return head;
    }
}
