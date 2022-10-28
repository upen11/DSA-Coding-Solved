//{ Driver Code Starts
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
            int ans = ob.NthTerm(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int NthTerm(int n)
    {
        // code here
        if(n == 1) {
            return 2;
        }
        
        long seq = 0;
        long prev = 2;
        for(long i=2; i<=n; i++) {
            seq = prev * i + 1;
            seq = seq%(1000000000 + 7);
            prev = seq;
        }
        
        // seq = seq%(1000000000 + 7);
        
        return (int)seq;
    }
}