class Solution {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int full = 0;

        // [91,54,63,99,24,45,78]
        // [35,32,45,98,6,1,25]
        // 17

        // creating remaingCap array and sorting it, so we can fill its capacity
        int[] remainingCap = new int[capacity.length];

        for (int i = 0; i < remainingCap.length; i++) {
            remainingCap[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(remainingCap);

        for (int i = 0; i < capacity.length; i++) {
            int diff = remainingCap[i];
            
            if (diff > additionalRocks) {
                additionalRocks = 0;
            } else if (diff < additionalRocks) {
                additionalRocks -= diff;
                full++;
            } else {
                additionalRocks = 0;
                full++;
            }
        }

        return full;
    }
}
