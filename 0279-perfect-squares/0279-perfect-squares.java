class Solution {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int count = 1;
        dp[0] = 0;

        while (count * count <= n) {
            int square = count * count;
            for (int i = square; i <= n; i++) {
                dp[i] = Math.min((dp[i - square] + 1), dp[i]);
            }
            count++;
        }

        return dp[n];
    }
}
