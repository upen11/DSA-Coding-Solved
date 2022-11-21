class MinStack {
    
    int[] stack;
    int[] minStack;
    int top;
    int min;

    public MinStack() {
        this.stack = new int[100000];
        this.minStack = new int[100000];
        this.top = -1;
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(min > val) {
            min = val;
        }
        
        if(top < stack.length) {
            top++;
            stack[top] = val;
            minStack[top] = min;
        }
        else
            System.out.println("Overflow");
    }
    
    public void pop() {
        if(top != -1) {
            top--;
        }
        
        if(top == -1)   // then empty stack was having last value
            min = Integer.MAX_VALUE;
        else
            min = minStack[top];
    }
    
    public int top() {
        if(top != -1)
            return stack[top];
        
        return -1;
    }
    
    public int getMin() {
        if(top != -1) {
            return minStack[top];
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */