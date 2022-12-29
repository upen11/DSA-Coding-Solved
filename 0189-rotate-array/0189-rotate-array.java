class Solution {

    // O(1) space
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;

        if (k == 0) return;

        // if k would have been -ve, add it to the length
        // if(k < 0) {
        //     k = k + n;
        // }

        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
    
    // O(n) Space
    /*
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        k = k % n;
        
        if(k == 0) return;
        
        int[] arr = new int[n];
        
        int i=0;
        while(k-- > 0) {
            arr[i++] = nums[n-k-1];
        }
        
        int z = 0;
        for(int j=i; j<n; j++) {
            arr[j] = nums[z++];     
        }
        
        
        for(int x=0; x<n; x++) {
            nums[x] = arr[x];
        }
         
    }
        */
}
