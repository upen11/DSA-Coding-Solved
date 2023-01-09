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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0, carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            ans.next = node;
            ans = ans.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode curr = null;
        if (l1 != null) curr = l1; else if (l2 != null) curr = l2;

        while (curr != null) {
            sum = curr.val + carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            ans.next = node;
            ans = ans.next;
            curr = curr.next;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            ans.next = node;
        }

        return dummy.next;
    }
}
