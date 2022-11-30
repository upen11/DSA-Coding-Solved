class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        Map<Integer, Integer> hm = new HashMap<>();
        
        Set<Integer> hset = new HashSet<>();
        
        for(int i=0; i<arr.length; i++) {
            if(hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i])+1);
            }
            else {
                hm.put(arr[i], 1);
            }
        }
        // System.out.println(hm);
        
        for(int i=0; i<arr.length; i++) {
            hset.add(hm.get(arr[i]));
        }
        
        // System.out.println(hset);
        
        return (hm.size() == hset.size());
    }
}