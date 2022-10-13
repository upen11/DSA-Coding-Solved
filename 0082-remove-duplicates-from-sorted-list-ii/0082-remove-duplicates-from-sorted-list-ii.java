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
        
        if(head == null) {
            return null;
        }
        
        // using HashSet
        ListNode firstPointer = head;
        ListNode currNode = head;

        Set<Integer> dupNums = new HashSet<>();
        // 1 2 3 3 4 4 5
        while (currNode.next != null) {
            if (currNode.val == currNode.next.val) {
                dupNums.add(currNode.val);
            }
            currNode = currNode.next;
        }

        // System.out.println(dupNums);  //[3, 4]
        head = deleteNodeWithData(head, dupNums);

        return head;
    }

    public static ListNode deleteNodeWithData(ListNode head, Set<Integer> dupNums) {
        // what if duplicate exists at start also, move head pointer further
        while (dupNums.contains(head.val)) {
            head = head.next;

            if (head == null) { // when all elements which head points to are duplicate. eg: 1 1 3 3
                return null;
            }
        }

        // System.out.println(head.val);

        ListNode currNode = head;
        ListNode firstPointer = head;
        while (currNode.next != null) {
            if (!dupNums.contains(currNode.next.val)) { // if next element is unique then firstPointer.next points to it
                firstPointer.next = currNode.next;
                firstPointer = firstPointer.next;
            }
            currNode = currNode.next;
        }

        // very important line
        if (dupNums.contains(currNode.val)) firstPointer.next = null;

        return head;
    }
}
