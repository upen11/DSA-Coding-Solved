class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<nums2.length; i++) {
            
           hm.put(nums2[i], i);
        }
        
        for(int i=0; i<nums1.length; i++) {
            
            int j = hm.get(nums1[i]);
            int val = nums2[j];
            boolean flag = false;
            for(; j<nums2.length-1; j++) {
                
                if(nums2[j+1] > val) {
                    nums1[i] = nums2[j+1];
                    flag = true;
                    break;
                }
            }
            
            if(flag == false) {
                nums1[i] = -1;
            }
        }
        
        return nums1;
        
    }
}