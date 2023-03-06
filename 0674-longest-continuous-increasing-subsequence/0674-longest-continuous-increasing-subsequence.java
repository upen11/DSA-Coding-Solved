class Solution {
    public int findLengthOfLCIS(int[] arr) {
        
        if(arr.length == 1) return 1;
        
        int count = 1;
        int maxCount = 0;
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] < arr[i+1]) {
                count++;  
            }
            else {
                count = 1;
            }
            
            maxCount = Math.max(maxCount, count);
        }
                
        return maxCount;
    }
}