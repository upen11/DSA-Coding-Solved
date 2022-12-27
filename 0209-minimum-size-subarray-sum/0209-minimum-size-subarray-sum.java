class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int p1 = 0, sum = 0;
        int diff = Integer.MAX_VALUE;

        for (int p2 = 0; p2 < nums.length; p2++) {
            sum += nums[p2];

            // asked in qus
            // here we are reducing sum, p2 is not increasing only p1 is
            while (sum >= target) {
                diff = Math.min(diff, p2 - p1 + 1);
                sum -= nums[p1];
                p1++;
            }
        }

        return diff == Integer.MAX_VALUE ? 0 : diff;
    }
}
