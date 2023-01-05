class Solution {
    // 4 5 6 7 2 3
    public int findMin(int[] nums) {
        
        int start = 0;
        int end = nums.length-1;
        
        // if array is sorted
        if(nums[start] <= nums[end]) return nums[start];
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            //[3, 1] for this I/P, we will get IndexOutOfBound if we put below condn above this
            if(nums[mid] > nums[mid + 1]) return nums[mid + 1];
            
            
            //[1, 3] is sorted and this is checked before
            if(nums[mid-1] > nums[mid]) return nums[mid];
            
            
            if(nums[0] < nums[mid]) {
                start = mid+1;
            }
            else if(nums[0] > nums[mid]) {
                end = mid - 1;
            }
        }
        
        return -1;
    }
}