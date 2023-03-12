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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        // [[],[1]]
        ListNode head = null;
        int x = 0;
        for (; x < lists.length; x++) {
            if (lists[x] != null) {
                head = lists[x];
                break;
            }
        }

        for (int i = x + 1; i < lists.length; i++) {
            ListNode prev = new ListNode(-1);

            ListNode curr1 = head;
            ListNode curr2 = lists[i];
            
            // [[2],[],[-1]]
            if(curr2 == null) continue;
            
            // [[1],[0]]
            head = curr1.val <= curr2.val ? curr1 : curr2;

            while (curr1 != null && curr2 != null) {
                if (curr1.val <= curr2.val) {
                    prev.next = curr1;
                    prev = curr1;
                    curr1 = curr1.next;
                } else {
                    prev.next = curr2;
                    prev = curr2;
                    curr2 = curr2.next;
                }
            }

            if (curr1 != null) {
                prev.next = curr1;
            }

            if (curr2 != null) {
                prev.next = curr2;
            }
        }

        return head;
    }
}
