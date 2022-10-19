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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode dummy = new ListNode(-1);
        ListNode newHead = dummy;
      
        while(list1 != null && list2 != null) {
            
            if(list1.val <= list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            }
            else {
                dummy.next = list2;
                list2 = list2.next;
            }
            
            dummy = dummy.next;
        }
        
        if(list1 == null) {
            dummy.next = list2;
        }
        
        if(list2 == null) {
            dummy.next = list1;
        }
        
        return newHead.next;
    }
}
//         ListNode sortedMergedList = new ListNode();
//         ListNode currNode = sortedMergedList;
        
//         ListNode nextNode = null;
        
//         if(list1 == list2) {
//             return null;
//         }
        
//         if(list1 == null) {
//             return list2;
//             }
//         else if(list2 == null) {
//              return list1;
//            }
        
//         if(list1.val <= list2.val) {
//             list1 = list1;
//         }
//         else{
//             ListNode temp = list1;
//             list1 = list2;
//             list2 = temp;
//         }
        
//         ListNode head1 = list1;
        
//         // no extra linked list        
//         while(list1.next != null) {
//              if((list1.val <= list2.val) && (list2.val <= list1.next.val)) {
//                  nextNode = list1.next;
//                  list1.next = list2;
//                  list1 = list2;
//                  list2 = nextNode;
//              }
//              else {
//                  list1 = list1.next;
//              }
           
//          }
//             list1.next = list2;
        
//          return head1;
        
//      }
    //Another approach
        
//         // extra linked list
//         while(list1 != null && list2 != null) {
//             if(list1.val < list2.val) {
//                 currNode.next = list1;
//                 list1 = list1.next;
//             }
//             else {
//                 currNode.next = list2;
//                 list2 = list2.next;
//             }
//             currNode = currNode.next;
//         }
        
//         if(list1 != null) {
//             currNode.next = list1;
//             // list1 = list1.next;
//         }
        
//         if(list2 != null) {
//             currNode.next = list2;
//             // list2 = list2.next;
//         }
        
//         return sortedMergedList.next;
//     }
// }