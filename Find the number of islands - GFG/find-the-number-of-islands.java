//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
    
    public void dfs(int ro, int co, char[][] grid, boolean[][] isVisited) {
        isVisited[ro][co] = true;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int i=-1; i<=1; i++) {
            for(int j=-1; j<=1; j++) {
                int nrow = ro + i;
                int ncol = co + j;
                
                if(nrow >=0 && nrow < rows && ncol >=0 && ncol < cols
                && isVisited[nrow][ncol] == false
                && grid[nrow][ncol] == '1') {
                    dfs(nrow, ncol, grid, isVisited);
                }
            }
        }
    }
    
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int count = 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean[][] isVisited = new boolean[rows][cols];
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(isVisited[i][j] == false && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid, isVisited);
                }
            }
        }
        return count;
    }
}