//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String addBinary(String A, String B) {
        // code here
        
        int m = A.length()-1;
        int n = B.length()-1;
        
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        int sum = 0;
        while(m>=0 || n>=0) {
            
            if(m >= 0 && n < 0) {
                sum = A.charAt(m)-'0' + carry;
            }
            else if(n >=0 && m < 0) {
                sum = B.charAt(n)-'0' + carry;
            }
            else {
                sum = A.charAt(m)-'0' + B.charAt(n)-'0' + carry;
            }
            
            if(sum == 1) {
                sb.append("1");
                carry = 0;
            } 
            else if(sum > 1) {
                if(sum == 2) {
                    sb.append("0");
                    carry = 1;
                }
                else {
                    sb.append("1");
                    carry = 1;
                }
            }
            else if(sum == 0) {
                sb.append("0");
            }
            
            m--;
            n--;
        }
        
        if(carry > 0)
            sb.append("1");
        
        sb.reverse();
        
        // int i=0;
        while(sb.charAt(0) != '1') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}