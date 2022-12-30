class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        int max = 0;
        while(k-- > 0) {
            max = maxFreq(freq);
            list.add(max);
        }
        
        int[] ans = new int[list.size()];
        
        for(int i=0; i<ans.length; i++) {
            ans[i] = list.get(i);
        }
        
        return ans;

    }
    
    int maxFreq(Map<Integer, Integer> freq) {
        int max = 0;
        int num = 0;
        for(int f : freq.keySet()) {
            if(max < freq.get(f)) {
                max = freq.get(f);
                num = f;
            }
        }
        
        freq.remove(num);
        return num;
    }
}
