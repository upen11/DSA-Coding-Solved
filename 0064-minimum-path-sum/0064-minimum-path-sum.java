class Solution {

    // memoization
    public int recursion(int[][] grid, int[][] dp, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        // last cell
        if (i == rows - 1 && j == cols - 1) return grid[i][j];

        if (dp[i][j] != -1) return dp[i][j];

        // last row
        if (i == rows - 1) {
            return dp[i][j] = grid[i][j] + recursion(grid, dp, i, j + 1);
        }
        // last col
        else if (j == cols - 1) {
            return dp[i][j] = grid[i][j] + recursion(grid, dp, i + 1, j);
        } // rest cases
        else {
            return dp[i][j] = grid[i][j] + Math.min(recursion(grid, dp, i + 1, j), recursion(grid, dp, i, j + 1));
        }
    }

    public int minPathSum(int[][] grid) {
        int sum = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        sum = recursion(grid, dp, 0, 0);

        return sum;
    }
}
