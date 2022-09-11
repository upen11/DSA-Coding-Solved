class Solution {

    public int arithmeticTriplets(int[] nums, int diff) {
        int triplets = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int element = nums[i];
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (element + diff == nums[j]) {
                    count++;
                    element = nums[j];
                }

                if (count == 2) {
                    triplets++;
                    break;
                } else if (element + diff < nums[j]) break;
            }
        }
        return triplets;
    }
}
