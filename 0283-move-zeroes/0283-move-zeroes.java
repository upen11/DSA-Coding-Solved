class Solution {
    public void moveZeroes(int[] nums) {
        
        int p1 = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[p1++] = nums[i];
            }
        }
        
        for(int i=p1; i<nums.length; i++) {
            nums[i] = 0;
        }
    }
}