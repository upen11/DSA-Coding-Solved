class Solution {
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int[] res = new int[nums.length];
        
        int j=0;
        for(int i=0; i<len; i+=2) {
            res[i] = nums[j++];
            res[i+1] = nums[n++];
        }
        
        return res;
    }
}