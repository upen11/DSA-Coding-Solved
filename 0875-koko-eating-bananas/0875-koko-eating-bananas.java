class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int p : piles) {
            max = Math.max(max, p);
        }

        int start = 1;
        int end = max;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int hrs = 0;
            for (int i = 0; i < piles.length; i++) {
                int d = piles[i] / mid;
                hrs += d;
                if (piles[i] % mid != 0) hrs++;

                if (hrs > h) {
                    break;
                }
            }

            if (hrs <= h) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
