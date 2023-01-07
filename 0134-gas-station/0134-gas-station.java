class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += (gas[i] - cost[i]);
        }

        if (tank < 0) return -1;

        int start = 0;
        int curr = 0;
        for (int i = 0; i < gas.length; i++) {
            curr += (gas[i] - cost[i]);
            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }

        return start;
    }
}
