class Solution {

    // using HashMap
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int freq = map.get(nums[i]);
                // System.out.println(freq);
                // number of pairs is equal to number of (pairs + previous freq)
                pairs += freq;
                map.put(nums[i], ++freq); // or (freq+1)
            } else {
                map.put(nums[i], 1);
            }
        }

        // System.out.print(map);
        return pairs;
    }
}
