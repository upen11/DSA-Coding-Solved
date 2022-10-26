//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            
            Solution ob = new Solution();
            System.out.println(ob.minFind(n, a));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minFind(int n, String a[]){
        // code here
        
        int redCount = 0;
        int blueCount = 0;
        int greenCount = 0;
        
        for(int i=0; i<n; i++) {
            
            if(a[i].equals("R")) {
                redCount++;
            }
            else if(a[i].equals("G")) {
                greenCount++;
            }
            else {
                blueCount++;
            }
        }
        
        // RR
        if(redCount == n || greenCount == n || blueCount == n) {
            return n;
        }
        
        // all colour are present in even or odd form (eee || ooo)
        if((redCount%2 == 0 && greenCount%2 == 0 && blueCount%2 == 0) || (redCount%2 == 1 && greenCount%2 == 1 && blueCount%2 == 1)) {
            return 2;
        }
        
        // mixture eeo eoo oee ooe
        return 1;
    }
}