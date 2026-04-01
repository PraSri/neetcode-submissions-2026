class MinStack {

    Stack<Integer> stack, minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                if (minStack.peek() > val) {
                    minStack.push(val);
                } else {
                    minStack.push(minStack.peek());
                }
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.isEmpty() ? -1 : minStack.peek();
        }
}
