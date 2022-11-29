class Solution {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] leftMin = new int[len];
        int[] rightMin = new int[len];

        findRightMin(heights, rightMin);
        findLeftMin(heights, leftMin);

        int area = 0;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int range = rightMin[i] - leftMin[i] - 1;

            area = range * heights[i];

            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    public void findRightMin(int[] heights, int[] rightMin) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                rightMin[stack.pop()] = i;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            rightMin[stack.pop()] = heights.length;
        }
    }

    public void findLeftMin(int[] heights, int[] leftMin) {
        Stack<Integer> stack = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                leftMin[stack.pop()] = i;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            leftMin[stack.pop()] = -1;
        }
    }
}
