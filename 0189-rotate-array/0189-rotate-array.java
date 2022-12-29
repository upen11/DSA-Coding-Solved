class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        k = k % n;
        
        if(k == 0) return;
        
        int[] arr = new int[n];
        
        int i=0;
        while(k-- > 0) {
            // System.out.println("i: "+ (n-k-1));
            arr[i++] = nums[n-k-1];
        }
        
        int z = 0;
        for(int j=i; j<n; j++) {
            // System.out.println("j: "+j);
            arr[j] = nums[z++];     
        }
        
        
        for(int x=0; x<n; x++) {
            nums[x] = arr[x];
        }
                                
    }
}