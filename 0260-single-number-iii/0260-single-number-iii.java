class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor = 0;
        for(int i=0; i<nums.length; i++) {
            xor ^= nums[i];   
        }
        
        int bit = xor & ~(xor-1); // can find the rightmost set bit.
        
        int[] res = new int[2];
        
        int set1 = 0;
        int set0 = 0;
        
        for(int i=0; i<nums.length; i++) {
            // separate using set bit
            if((nums[i] & bit) > 0 ) {
                set1 ^= nums[i];
            }
            else {
                set0 ^= nums[i];
            }
        }
        
        res[0] = set1;
        res[1] = set0;
        
        return res;
    }
}