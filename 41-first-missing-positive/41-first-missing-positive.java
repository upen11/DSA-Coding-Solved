class Solution {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) set.add(nums[i]);
        }

        // <=len for [1,2,3,4,5]  5 will be searched at last when len = nums.length
        for (int i = 1; i <= len; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return len + 1;
    }
}
