class Solution {

    public int arrangeCoins(int n) {
        // index    1  2  3  4   5    k-1  k
        // count    1, 3, 6, 10, 15....... k(k+1)/2     // sum of natural numbers
        
        long start = 1;
        long end = n / 2 + 1;
        long curr = 0;

        while (start <= end) {
            curr = start + (end - start) / 2;
            long sum = (long) (curr * (curr + 1) * 0.5);

            if (sum == n) {
                return (int) curr;
            } else if (sum < n) {
                start = curr + 1;
            } else {
                end = curr - 1;
            }
        }

        return (int) end;
    }
}
