class Solution {

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                int ind = nums[i] - 1;
                swap(nums, i, ind);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) return j + 1;
        }

        return nums.length + 1;
    }

    public void swap(int[] nums, int i, int ind) {
        int temp = nums[i];
        nums[i] = nums[ind];
        nums[ind] = temp;
    }
}
