class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String str = "+-*/";
        for(int i=0; i<tokens.length; i++) {
            // System.out.println(stack);
            if(str.contains(tokens[i])) {
                int b = stack.pop();
                int a = stack.pop();
                int c = operations(tokens[i], a, b);
                stack.push(c);
            }
            else {
                stack.add(Integer.parseInt(tokens[i]));
            }
        }
        
        return stack.pop();
    }
    
    public int operations(String op, int a, int b) {
        if(op.equals("+")) return a + b;
        if(op.equals("-")) return a - b;
        if(op.equals("*")) return a * b;
        if(op.equals("/")) return a / b;
        
        return 0;
    }
}