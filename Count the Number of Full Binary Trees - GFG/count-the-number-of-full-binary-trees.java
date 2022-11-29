//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.numoffbt(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    // 4
    // 2 6 2 3  O/P: 5
    // 20
    // 16 4 14 27 18 28 20 29 19 23 21 12 6 9 24 3 30 8 22 17  O/P: 34
    public static int numoffbt(int arr[], int n)
    {
         // Your code goes here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        final int mod = 1000000007;
         
        // finding min and max elements in the array 
        for(int i=0; i<n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        
        // visited array tells us if the number is present in the array or not (index is used as numbers)
        // max+1 cause indexing starts from 0 and array goes till max value
        int[] visited = new int[max+1];
        // value array stores how many binary trees can be made
        int[] value = new int[max+1];
        
        for(int i=0; i<n; i++) {
            visited[arr[i]] = 1; // 1 = number is present in array
            value[arr[i]] = 1; // one node can make 1 binary tree
        }
        
        int sum = 0;
        for(int i=min; i<=max; i++) {
            if(visited[i] == 0) continue;
            for(int j=2; i*j <= max && j<=i; j++) {
                if(visited[i*j] == 0) continue; // if multiple is there, then only proceed
                
                value[i*j] = (value[i*j] + (value[i] * value[j])%mod)%mod;  // storing i*j values in value array
                
                if(i != j) {
                  value[i*j] = (value[i*j] + (value[i] * value[j])%mod)%mod; 
                }
            }
            
            sum += value[i];    // summing for ith element in values
        }
        
        return sum % mod;
    }
}