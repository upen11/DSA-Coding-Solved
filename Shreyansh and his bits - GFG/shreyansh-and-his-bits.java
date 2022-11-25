//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            long  N = Long.parseLong(input_line[0]);
            Solution ob = new Solution();
            System.out.println(ob.count(N));
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
    long[][] arr;
    long count(long n)
    {
        arr = new long[40][40];
        
        for(int i=0; i<arr.length; i++) {
            Arrays.fill(arr[i], -1);
        }
        
        int one = 0; // no. of 1's
        int bor = 0; // bits on the right
        long ans = 0;
        while(n != 0) {
            if(n % 2 == 1) {
                one++;
                ans += ncr(bor, one);   // combinations of 1 on the places on the right  _ _ _
            }
            
            n = n / 2;
            bor++;
        }
        
        return ans;
    }
    
    long ncr(int n, int r) {
        if(r==0 || n==r) return 1;
        
        if(r > n) return 0;
        
        if(arr[n][r] != -1) return arr[n][r];
    
        arr[n][r] = ncr(n-1, r-1) + ncr(n-1, r);
        
        return arr[n][r];
    }
}