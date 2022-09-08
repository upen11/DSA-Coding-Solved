class Solution {

    public int heightChecker(int[] heights) {
        int len = heights.length;
        int[] expected = new int[len];

        for (int i = 0; i < heights.length; i++) {
            expected[i] = heights[i];
        }

        // doing insertion sort
        for (int i = 1; i < expected.length; i++) {
            int key = expected[i];
            
            int j = i - 1;

            while (j >= 0 && expected[j] > key) {
                expected[j + 1] = expected[j];
                j--;
            }

            expected[j + 1] = key;
        }

        //         for (int i = 0; i < expected.length; i++) {
        //             System.out.print(expected[i] + " ");
        //         }

        //        System.out.println();

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) count++;
        }

        return count;
    }
}
