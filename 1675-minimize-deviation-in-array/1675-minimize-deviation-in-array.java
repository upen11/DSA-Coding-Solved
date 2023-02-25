class Solution {

    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> (b - a));

        int minE = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i % 2 != 0) 
                i = i * 2;

            maxQueue.add(i);

            minE = Math.min(minE, i);
        }

        int maxE = maxQueue.remove();

        int deviation = maxE - minE;

        while (maxE % 2 == 0) {
            maxE = maxE / 2;
            minE = Math.min(minE, maxE);
            
            maxQueue.add(maxE);

            maxE = maxQueue.remove();
            
            deviation = Math.min(deviation, maxE - minE);
        }

        return deviation;
    }
}
