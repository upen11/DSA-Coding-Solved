class Solution {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int sign = 1;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {
                int nums = 0;
                while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                    nums = nums * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                nums = nums * sign;
                sign = +1;
                sum += nums;
            } else if (ch == '(') {
                stack.push(sum);
                stack.push(sign);
                sign = +1;
                sum = 0;
            } else if (ch == ')') {
                sum *= stack.pop(); // popping sign
                sum += stack.pop(); // popping sum
            } else if (ch == '-') {
                sign *= -1;
            }
        }

        return sum;
    }
}
