class Solution {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);

            max = Math.max(map.get(i), max);
        }

        Set<Integer> set = new HashSet<>();

        for (Integer i : map.keySet()) {
            if (map.get(i) == max) {
                set.add(i);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (Integer i : set) {
            int count = 0;
            int freq = 0;
            
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) freq++;
                
                if(freq == 0) {
                    continue;
                }
                
                count++;

                if (freq == max) break;
            }

            ans = Math.min(count, ans);
        }

        return ans;
    }
}
