class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        int maxFreq = 0;
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
            int frequency = freq.get(i);
            maxFreq = Math.max(frequency, maxFreq);
        }

        List<Integer>[] bucket = new List[maxFreq + 1];

        for (int key : freq.keySet()) {
            int fq = freq.get(key);
            if (bucket[fq] == null) {
                bucket[fq] = new ArrayList<>();
            }
            bucket[fq].add(key);
        }
        
        // for (List<Integer> i : bucket) System.out.println(i);

        int[] a = new int[k];
        int ind = 0;
        for (int i = maxFreq; i > 0 && k > 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size(); j++) {
                    a[ind++] = bucket[i].get(j);
                    k--;
                }
            }
        }
        return a;
    }
}
