//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.BalancedString(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int sumOfDigit = 0;
    static String BalancedString(int N) {
        // code here
        StringBuilder sb = new StringBuilder();
        
        int num = N, n = 0;
        sumOfDigit = 0;
        while(num > 0) {
            int rem = num % 10;
            sumOfDigit += rem;
            num /= 10;
        }
        
        while(N > 0) {
            
            if(N > 26) {
                n = 26;
            }
            else {
                n = N;
            }
            
            sb = result(n, sb);
            
            N = N-26;
        }
        
        return sb.toString();
    }
    
    
    static StringBuilder result(int N, StringBuilder sb) {
        
        // Even
        if(N%2 == 0) {
            for(int i=0; i<N/2; i++) {
                sb.append((char)(i+97));
            }

            StringBuilder rev = new StringBuilder();
            for(int j=122; j>122-(N/2); j--) {
                rev.append((char)(j));
            }
            
            rev.reverse();
            sb.append(rev);
        }
        // odd
        else {
            // sumOfDigit = even
            if(sumOfDigit % 2 == 0) {
                for(int i=0; i<(N+1)/2; i++) {
                    sb.append((char)(i+97));
                }
            
                StringBuilder rev = new StringBuilder();
                for(int j=122; j>122-(N-1)/2; j--) {
                    rev.append((char)(j));
                }
            
                rev.reverse();
                sb.append(rev);
            }
            // sumOfDigit = odd
            else {
                for(int i=0; i<(N-1)/2; i++) {
                    sb.append((char)(i+97));
                }
            
                StringBuilder rev = new StringBuilder();
                for(int j=122; j>122-(N+1)/2; j--) {
                    rev.append((char)(j));
                }
            
                rev.reverse();
                sb.append(rev);
            }
            
        }
        
        return sb;
    }
    
    
}