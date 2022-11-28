class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<nums1.length; i++) {
            hm.put(nums1[i], -1);
        }
 
        // maintain a hash map to map nums1 array
        // traversing nums2 from left
        // pushing indexes in stack
        // if next element is greater than top, ans[st.pop()] = nums[index]
        // updating in map
        // use while inside for loop eg [1,3,5,2,4]
                                    // [6,5,4,3,2,1,7]
        // expected [7,7,7,7,7]

        
        for(int i=0; i<nums2.length; i++) {
            
            while(!stack.isEmpty() && (nums2[i] > nums2[stack.peek()]) ) {
                int k = stack.pop();
                // nums2[0] 1 -> nums2[1] 3
                if(hm.containsKey(nums2[k])) {
                    hm.put(nums2[k], nums2[i]);
                }
            }
            
            stack.push(i);
        }
        
        for(int i=0; i<nums1.length; i++) {
                nums1[i] = hm.get(nums1[i]);
        }
        
        return nums1;
    }
}