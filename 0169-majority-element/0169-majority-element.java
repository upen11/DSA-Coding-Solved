class Solution {

    public int majorityElement(int[] nums) {
        // [2,2,1,1,1,2,2]
        // 2
        // Boyer-Moore Voting Algorithm
        int candidate = 0, count = 0;
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
            }

            if (i == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
