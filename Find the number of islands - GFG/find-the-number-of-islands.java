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


// We made pair class because we need to traverse in all 8 directions
// i = row and j = col of the grid[i][j] = '1'. 
// We will then traverse from this co-ordinate in all 9 directions
class Pair {
    int i;
    int j;
        
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

// TC : O(m * n)
// SC : O(m * n)

class Solution {
    
    // how to do traversal => we will find a node where it is '1'. Then we will do bfs in all 8 directions.
    // if we are able to traverse then how to count islands => we will have a outer loop where we will go from 0 to m*n.
    // we will process only those who are '1' and not visited.
   
    public void bfs(int r, int c, char[][] grid, boolean[][] isVisited) {
        
        isVisited[r][c] = true;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r, c));
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        while(!queue.isEmpty()) {
            
            Pair node = queue.poll();
            
            int row = node.i;
            int col = node.j;
            
            // traversing neighbours and marking them true
            for(int i=-1; i<=1; i++) {
                for(int j=-1; j<=1; j++) {
                    
                    // neighbour row and col in 8 directions, well 9 when we have row+0 and col+0
                    int nrow = row + i;
                    int ncol = col + j;
                    
                    // valid conditions(inside matrix), need to be land and non-visited
                    if(nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols 
                    && grid[nrow][ncol] == '1' 
                    && isVisited[nrow][ncol] == false) {
                        isVisited[nrow][ncol] = true;
                        queue.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
        
    }
    
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        // {
        // {0,1,1,1,0,0,0},
        // {0,0,1,1,0,1,0}
        // }
        // given a 2D matrix
        // we need a visited array
        // then we need to do bfs/dfs in all 8 directions where we can find connecting 1's
        
        int count = 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean[][] isVisited = new boolean[rows][cols];
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                char node = grid[i][j];
                
                if(isVisited[i][j] == false && node == '1') {
                    count++;
                    bfs(i, j, grid, isVisited); // bfs means to work with Queue and see neighbours
                }
            }
        }
        return count;
    }
}