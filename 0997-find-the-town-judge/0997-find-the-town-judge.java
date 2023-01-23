class Solution {

    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1) return 1;

        int[] count = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            int out = trust[i][0];
            int in = trust[i][1];

            count[out]--;
            count[in]++;
        }

        // System.out.println(Arrays.toString(count));

        for (int i = 1; i < count.length; i++) {
            if (count[i] == n - 1) return i;
        }

        return -1;
    }
}
