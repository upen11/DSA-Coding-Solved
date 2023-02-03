class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i : nums) {
            minHeap.add(i);
        }
        
        k = nums.length - k;
        for(int i=0; i<k; i++) {
            minHeap.poll();
        }
        
        return minHeap.poll();
    }
}