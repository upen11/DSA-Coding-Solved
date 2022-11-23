//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.maxSumLCM(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long maxSumLCM(int n) {
        // code here
        long sum = 0;
        for(int i=1; i<=Math.sqrt(n); i++) {
            if(n%i == 0) {
                sum += i + n/i;
            }
            if(i*i == n) {
                sum -= i;
            }
        }

        return sum;
    }
}