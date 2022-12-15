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
            
            n = (N > 26) ? 26 : N;
            
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
            
            // added +1 to j because the last 122 is also included 
            for(int j=122-(N/2)+1; j<=122; j++) {
                sb.append((char)(j));
            }
        }
        // odd
        else {
            // sumOfDigit = even
            if(sumOfDigit % 2 == 0) {
                for(int i=0; i<(N+1)/2; i++) {
                    sb.append((char)(i+97));
                }
                
                for(int j=122-(N-1)/2+1; j<=122; j++) {
                    sb.append((char)(j));
                }
            }
            // sumOfDigit = odd
            else {
                for(int i=0; i<(N-1)/2; i++) {
                    sb.append((char)(i+97));
                }
                
                for(int j=122-(N+1)/2+1; j<=122; j++) {
                    sb.append((char)(j));
                }
            }
            
        }
        
        return sb;
    }
    
    
}