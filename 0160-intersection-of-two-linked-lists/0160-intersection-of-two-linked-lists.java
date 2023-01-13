/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode A = headA;
        ListNode B = headB;
        
        int cnt1 = 0;
        int cnt2 = 0;
        while(A != null || B!= null) {
            if(A != null) {
                cnt1++;
                A = A.next;
            }
            
            if(B != null) {
                cnt2++;
                B = B.next;
            }
        }
        
        int diff = Math.abs(cnt2 - cnt1);
        
        if(cnt2 > cnt1) 
            for(int i=0; i<diff; i++) {
                headB = headB.next;
            }
        else {
            for(int i=0; i<diff; i++) {
                headA = headA.next;
            }
        }
        
        while(headA != null) {
            if(headA == headB)
                return headA;
            
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}