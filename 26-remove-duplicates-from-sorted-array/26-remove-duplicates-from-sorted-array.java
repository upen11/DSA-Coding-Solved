class Solution {
    public int removeDuplicates(int[] nums) {
        
        int p1 = 0;
        // [0,0,1,1,1,2,2,3,3,4]
        for(int i=1; i<nums.length; i++) {
            
            if(nums[i] == nums[i-1]) {
                continue;
            }
            else {
                nums[++p1] = nums[i];
            }
        }
            
            for(int i: nums)
                System.out.print(i+" ");
            
            return p1+1;
        
    }
}