class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            if(hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i])+1);
            }
            else {
                hm.put(arr[i], 1);
            }
        }
        
//         for(int i=0; i<arr.length; i++) {
//             hset.add(hm.get(arr[i]));
//         }
        
        Set<Integer> hset = new HashSet<>(hm.values());  // we can give map.values in set parameters
        
        return (hm.size() == hset.size());
    }
}