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
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        
        ListNode dHead = head;
        ListNode prev = head;
        ListNode node = prev.next;
        ListNode ansHead = node;
        ListNode nxt = node.next;
        
        node.next = prev;
        prev.next = null;
        
        prev = nxt;
        while(prev != null && prev.next != null) {
            node = prev.next;
            nxt = node.next;
            
            node.next = prev;
            prev.next = null;
            
            dHead.next = node;
            dHead = prev;
            prev = nxt;
        }
        
        if(prev != null) {
            dHead.next = prev;
        }
        
        return ansHead;
    }
}