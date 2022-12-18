class Solution {

    // [89,62,70,58,47,47,46,76,100,70]
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;

        int[] ans = new int[n];
        stack.add(n - 1);
        ans[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int sum = 0;

            System.out.println(stack);
            if (!stack.isEmpty() && temperatures[stack.peek()] > temperatures[i]) {
                ans[i] = 1;
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[i] = 0;
                } else {
                    ans[i] = stack.peek() - i;
                }
            }

            stack.push(i);
        }

        return ans;
    }
}
