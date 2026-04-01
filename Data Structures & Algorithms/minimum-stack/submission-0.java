class MinStack {

    Stack<Integer> s1, s2;
    public MinStack() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>(); // keeps min value
    }
    
    public void push(int val) {
        s1.push(val);
        if(s2.empty()) {
            s2.push(val);
        } else {
            Integer currMin = s2.peek();
            if(currMin < val) {
                s2.push(currMin);
            } else {
                s2.push(val);
            }
        }
    }
    
    public void pop() {
        s1.pop();
        s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}
