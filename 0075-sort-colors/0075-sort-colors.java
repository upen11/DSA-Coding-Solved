class Solution {
    public void sortColors(int[] nums) {
        
        int start=0;
        int end = nums.length-1;
        int ind=0;
        
        while(start < end && ind <= end) {
            if(nums[ind] == 0) {
                swap(start, ind, nums);
                ind++;
                start++;
            }
            else if(nums[ind] == 2) {
                swap(ind, end, nums);
                end--;
            }
            else {
                ind++;
            }
        }
    }
    
    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}