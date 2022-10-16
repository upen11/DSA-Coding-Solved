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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode currNode = head;
        ListNode unique = head;
        ListNode newHead = unique;
        
        while(currNode.next != null) {
            if(currNode.val != currNode.next.val) {
                unique.next = currNode.next;
                unique = unique.next;
            }
            currNode = currNode.next;
        }
        
        if(unique.val == currNode.val) {
            unique.next = null;
        }
        
        return newHead;
    }
}
// This approach is more optimal I think
/*
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        // ListNode tail = null;
        
        while(curr != null) {
            if(curr.next == null) {
                // tail = curr;
                break;
            }
            else if(curr.val == curr.next.val) {
                curr.next = curr.next.next;
                // size--;
            }
            else {
                curr = curr.next;
            }
        }
     
        return head;
    }
}
*/