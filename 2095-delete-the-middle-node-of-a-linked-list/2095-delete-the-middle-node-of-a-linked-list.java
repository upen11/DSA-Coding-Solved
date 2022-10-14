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

        if (head.next == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slowPointer = dummy;
        ListNode fastPointer = head;

        while (fastPointer.next != null) {
            slowPointer = slowPointer.next;
            if (fastPointer.next.next != null) {
                fastPointer = fastPointer.next.next; }
            else {
                break;
            }
        }

        slowPointer.next = slowPointer.next.next;

        return head;
    }
}
