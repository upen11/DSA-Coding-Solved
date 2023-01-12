class Solution {

    // [89,62,70,58,47,47,46,76,100,70]
    // consider for duplicates too
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);
        int[] ans = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && (temperatures[i] >= temperatures[stack.peek()])) 
                stack.pop();

            if (!stack.isEmpty()) {
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return ans;
    }
}
