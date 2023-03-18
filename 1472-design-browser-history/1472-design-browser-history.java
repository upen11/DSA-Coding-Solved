class BrowserHistory {

    Stack<String> backward = null;
    Stack<String> forward = null;
    public BrowserHistory(String homepage) {
        backward = new Stack<>();
        forward = new Stack<>();
        backward.push(homepage);
    }
    
    public void visit(String url) {
        backward.push(url);
        forward.clear();
    }
    
    public String back(int steps) {
        // System.out.println("backward:start "+backward);
        while(backward.size() > 1 && steps-- > 0) {
            String url = backward.pop();
            forward.push(url);
        }
        // System.out.println("backward end: "+backward);
        System.out.println();
        return backward.peek();
    }
    
    public String forward(int steps) {
        // System.out.println("forward start: "+forward);
        while(forward.size() > 0 && steps-- > 0) {
            String url = forward.pop();
            backward.push(url);
        }
        // System.out.println("forward end: "+forward);
        return backward.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */