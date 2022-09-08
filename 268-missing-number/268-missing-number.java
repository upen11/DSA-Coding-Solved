class Solution {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        double sumOfArray = 0.5*n*(n+1);
        
        double missingNo = sumOfArray;
        for(int i=0; i<n; i++) {
            missingNo -= nums[i];
        }
        
        return (int)missingNo;
    }
}
