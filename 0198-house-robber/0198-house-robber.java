class Solution {

    // we need to search the max of previous two, this is the case if we do not pick the num,
        // second is if we pick this num then we need to sum it with arr[n-2] and find the max.
        
    // public int rob(int[] nums) {

//         int dp[] = new int[nums.length];

//         dp[0] = nums[0];
//         if (nums.length == 1) return dp[0];

//         dp[1] = Math.max(nums[0], nums[1]);
//         if (nums.length == 2) return dp[1];

//         for (int i = 2; i < nums.length; i++) {
//             dp[i] = Math.max(dp[i - 1], dp[i - 2]);
//             dp[i] = Math.max(nums[i] + dp[i - 2], dp[i]);
//         }

//         return dp[nums.length - 1];
//     }
    
    
    // without extra space
        public static int rob(int[] nums) {
        int ifRobbedPrevious = 0; // max money can get if rob current house
        int ifDidntRobPrevious = 0; // max money can get if not rob current house

        // We go through all the values, we maintain two counts, 1) if we rob this cell, 2) if we didn't rob this cell
        for (int i = 0; i < nums.length; i++) {
            // If we rob current cell, previous cell shouldn't be robbed. So, add the current value to previous one.
            int currRobbed = ifDidntRobPrevious + nums[i];

            // If we don't rob current cell, then the count should be max of the previous cell robbed and not robbed
            int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious);

            // Update values for the next round
            ifDidntRobPrevious = currNotRobbed;
            ifRobbedPrevious = currRobbed;
        }

        return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
    }
    
    
}
