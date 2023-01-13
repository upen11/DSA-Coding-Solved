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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        
        ListNode curr = head;
        int l = left;
        
        ListNode prev1 = null;
        
        while(--l > 0) {
            prev1 = curr;
            curr = curr.next;
        }
        
        ListNode leftNode = curr;
        ListNode prev2 = null;
        while(right-- >= left) {
            ListNode nextNode = curr.next;
            curr.next = prev2;
            prev2 = curr;
            curr = nextNode;
        }
        
        if(prev1 != null) {
            prev1.next = prev2;
            leftNode.next = curr;
        }
        else {
            head.next = curr;
            head = prev2;
        }
        
        return head;
    }
}
