//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.UniquePartitions(n);
            for(ArrayList<Integer>i: ans)
                for(int j: i)
                    System.out.print(j + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    {
        // Code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = n-i;
        }
        
        
        helper(arr, list, 0, 0, n, new ArrayList<>());
        
        // System.out.println(list);
        
        return list;
    }
    
    public static void helper(int[] arr, ArrayList<ArrayList<Integer>> list, int ind, int sum, int target, ArrayList<Integer> ds) {
        
        if(sum == target) {
            if(ds.size() > 0) {
                list.add(new ArrayList<>(ds));
                return;
            }
        }
        
        if(ind >= arr.length || sum > target) return;
        
        for(int i=ind; i<arr.length; i++) {
            
            ds.add(arr[i]);
            sum += arr[i];
            helper(arr, list, i, sum, target, ds);
            ds.remove(ds.size()-1);
            sum -= arr[i];
        }
    }
}