class Solution {
    public int findLengthOfLCIS(int[] arr) {
        
        int count = 1;
        int maxCount = 0;
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] < arr[i+1]) {
                count++;
                maxCount = Math.max(maxCount, count);
            }
            else {
                count = 1;
            }
        }
        
        maxCount = Math.max(maxCount, count);
        
        return maxCount;
    }
}