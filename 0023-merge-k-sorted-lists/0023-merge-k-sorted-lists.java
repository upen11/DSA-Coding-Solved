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

    // T.C O(N * KlogK)
    // S.C O(1)

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        // 1. divide and conquer
        // 2. mergingTwoSortedLL
        ListNode head = divideAndConquer(lists, 0, lists.length - 1);

        return head;
    }

    public ListNode divideAndConquer(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];

        int mid = start + (end - start) / 2;

        ListNode l1 = divideAndConquer(lists, start, mid);
        ListNode l2 = divideAndConquer(lists, mid + 1, end);

        return mergingTwoSortedLL(l1, l2);
    }

    public ListNode mergingTwoSortedLL(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;

        if (l2 == null) return l1;

        ListNode head = l1.val <= l2.val ? l1 : l2;

        ListNode prev = new ListNode(-1);
        ListNode curr1 = l1;
        ListNode curr2 = l2;

        while (curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                prev.next = curr1;
                curr1 = curr1.next;
            } else {
                prev.next = curr2;
                curr2 = curr2.next;
            }
            prev = prev.next;
        }

        prev.next = curr1 == null ? curr2 : curr1;

        return head;
    }
    // T.C O(K2 * N)
    // S.C O(1)
    /*
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
    */
}
