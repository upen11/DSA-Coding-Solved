class Solution {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        int maxDegree = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            if (left.get(nums[i]) == null) left.put(nums[i], i);

            right.put(nums[i], i);

            maxDegree = Math.max(maxDegree, freq.get(nums[i]));
        }

        int ans = Integer.MAX_VALUE;
        for (int i : freq.keySet()) {
            if (freq.get(i) == maxDegree) {
                ans = Math.min(ans, right.get(i) - left.get(i) + 1);
            }
        }

        return ans;
    }
}
