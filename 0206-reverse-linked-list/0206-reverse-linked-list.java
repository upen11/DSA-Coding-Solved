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
    public ListNode reverseList(ListNode head) {
        
        if(head == null) {
            return null;
        }
        
        ListNode previous = null;
        ListNode currNode = head;
        ListNode nextNode = head.next;
        
        while(nextNode != null){
            currNode.next = previous;
            
            previous = currNode;
            currNode = nextNode;
            nextNode = nextNode.next;
        }
        
        currNode.next = previous;
        
        return currNode;
    }
}
        
//         ListNode nextNode = null;
//         ListNode prevNode = null;
        
//        while(head != null) {
//            nextNode = head.next;
//            head.next = prevNode;
//            prevNode = head;
//            head = nextNode;
//        }
//         head = prevNode;  
//         return head;
//     }
// }