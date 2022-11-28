//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    // 8
    // 1 2 5 -7 2 3 2 1
    ArrayList<Integer> findSubarray(int a[], int n) {
        // code here
        
        ArrayList<Integer> list = new ArrayList<>();
        
        long sum = 0, maxSum = Integer.MIN_VALUE;   // initailized as Min Value
        int len = 0, maxLen = 0;
        int startInd = 0, endInd = 0;
    
        for(int i=0; i<n; i++) {
            
            if(a[i] < 0) {  // -ve values
                sum = 0;
                len=0;  
                continue;
            }
            
            sum += a[i];
            len++;
            
            if(sum > maxSum) {
                maxSum = sum;
                endInd = i;
                maxLen = len;
            }
            else if (sum == maxSum && len > maxLen) {  // I am checking the length of subarray when sum is equal
                endInd = i;
                maxLen = len;
            }
            
        }
        

        startInd = endInd - maxLen + 1; // idea is to get starting of the subarray using last index and length of subarray
        
        if(maxSum < 0) {   //  as max sum will only get updated in case of non-negative value
            list.add(-1);
            return list;
        }
        
        for(int i=startInd; i<=endInd; i++) {
            list.add(a[i]);
        }
        
        return list;
    }
}