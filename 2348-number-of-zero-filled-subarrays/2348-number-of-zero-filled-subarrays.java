class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        for(int i=0; i<nums.length; i++) {
            long subarrays = 0;
            if(nums[i] == 0) {
                long zeroes = 0;
                while(i < nums.length && nums[i] == 0) {
                    zeroes++;
                    i++;
                }
                subarrays = zeroes * (zeroes + 1) / 2;
            }
            ans += subarrays;
        }
        
        return ans;
    }
}