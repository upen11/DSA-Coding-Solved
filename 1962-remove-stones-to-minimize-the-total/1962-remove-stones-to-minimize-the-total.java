class Solution {

    // Time complexity: O((n + k) log n)
    // Space complexity: O(n)

    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int stones : piles) pq.add(stones);

        for (int i = 0; i < k; i++) {
            int stones = pq.remove();
            stones -= stones / 2;
            pq.add(stones);
        }

        return pq.stream().mapToInt(e -> e).sum();
    }
}
