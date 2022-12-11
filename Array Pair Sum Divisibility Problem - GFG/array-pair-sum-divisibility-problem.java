//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        // if length is odd then we can't form all pairs
        if(nums.length % 2 != 0) return false;
        
        //creating an array to store remainders freq ( can also use hashmap)
        int[] remFreq = new int[k]; // size is not k+1 because if num == k then rem will be 0
        
        for(int i : nums) {
            remFreq[i%k]++;
        }
        
        // because if we do remFreq[0] != remFreq[k-0], it will give arrayOutOfBound exception, better to know if it is even
        if(remFreq[0] % 2 != 0 || remFreq[k/2] % 2 != 0) return false;
        
        // i<k/2 because we want to know if we can form pairs
        for(int i=1; i<k/2; i++) {
            
            // if two remainders are having same count then they can form pairs
            if(remFreq[i] != remFreq[k-i]) {
                return false;
            }
        }
        
        return true;
    }
}