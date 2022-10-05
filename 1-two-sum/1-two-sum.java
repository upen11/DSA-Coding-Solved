class Solution {
    // solved using hashmap
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // going till half+1, giving wrong ans, what if numbers are at last
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            
            // rem should not be the same number i.e same index
            if (map.containsKey(rem) && map.get(rem) != i) {
                return new int[] { i, map.get(rem) };
            }
        }

        return new int[] { -1, -1 };
    }
}
