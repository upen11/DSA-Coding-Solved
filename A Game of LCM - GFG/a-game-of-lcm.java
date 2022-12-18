//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.maxGcd(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long maxGcd(int N) {
        // code here
        return Math.max(solve(N), solve(N-1));
    }
    
    
    // a * b = lcm(a,b) * hcf(a,b) --> lcm(a,b) = a*b / hcf(a*b); for lcm to be highest hcf should be 1;
     long solve(int N)
    {
        long x = (N* (N-1))/gcd(N,N-1);
        long y = ((N-2) * (N-3)) / gcd(N-2,N-3);
        
        long z = (x*y)/gcd(x,y);
        
        //s2 need to compare with other approach
        long num =(N *(N-1));
        int count=0;
        for(int i=N-2; i>=1; i--)
        {
            if(gcd(num,i)==1)
            {
                // System.out.println(i);
                num *= i;
                count++;
            }
            if(count==2) break;
        }
        return Math.max(z,num);
    }
    
    public long gcd(long a, long b) {
        if(b == 0) return a;
        
        return gcd(b, a%b);
    }
}