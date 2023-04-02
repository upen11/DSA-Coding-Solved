class Solution {

    public int binarySearch(int start, int end, int[] potions, double minPotion) {
        int possibleInd = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (potions[mid] >= minPotion) {
                possibleInd = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return possibleInd;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length;
        int n = potions.length;

        int[] ans = new int[m];

        Arrays.sort(potions);

        int lastIndVal = potions[n - 1];

        for (int i = 0; i < m; i++) {
            // spells * potions = success
            double minPotion = Math.ceil((success * 1.0) / spells[i]);

            if (minPotion > lastIndVal) ans[i] = 0; else {
                int minIndex = binarySearch(0, n - 1, potions, minPotion);
                ans[i] = n - minIndex;
            }
        }

        return ans;
    }
}
