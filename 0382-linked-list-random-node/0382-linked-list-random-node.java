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
    // T.N O(N)
    // S.C O(1)
    // Reservoir Sampling
    ListNode newHead = null;

    public Solution(ListNode head) {
        newHead = head;
    }

    public int getRandom() {
        Random random = new Random();

        ListNode curr = newHead;
        int i = 1;
        int ans = 0;
        while (curr != null) {
            int r = random.nextInt(10001);
            if (r % i == 0) {   // this will give each element a equal chance to te picked
                ans = curr.val;
            }

            i++;
            curr = curr.next;
        }

        return ans;
    }
    // T.N : O(N)
    // S.C : O(N)

    /* 
    List<Integer> list = null;
    public Solution(ListNode head) {
        list = new ArrayList<>();
        
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        Random random = new Random();
        int r = random.nextInt(list.size());
        return list.get(r);
    }
    */
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
