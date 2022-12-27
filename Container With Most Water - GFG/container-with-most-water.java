//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
import java.lang.*;


class GFG {
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine()); // input size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split("\\s+");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    Solve T = new Solve();
            long ans = T.maxArea(arr,n);
            System.out.println(ans);
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solve{
    
    long maxArea(int A[], int len){
        // Code Here
        
        if(len < 2) return 0L;
        
        int p1 = 0;
        int p2 = len-1;
        long ans = 0;
        while(p1 < p2) {
            int canHoldWater = Math.min(A[p1], A[p2]) * (p2 - p1);
            ans = Math.max(ans, canHoldWater);
            
            if(A[p2] < A[p1]) {
                p2--;
            }
            else {
                p1++;
            }
        }
        
        return ans;
    }
    
}