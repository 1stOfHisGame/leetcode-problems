class MyStack {

    Queue<Integer> stack;
    Queue<Integer> sstack;
    
    /** Initialize your data structure here. */
    public MyStack() {
        stack = new LinkedList<Integer>();
        sstack = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        stack.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int popped = 0;
        while(stack.peek()!=null){
            popped = stack.remove();
            if(stack.peek()!=null)
                sstack.add(popped);    
        }
        while(sstack.peek()!=null){
            stack.add(sstack.remove());    
        }
        return popped;
        
    }
    
    /** Get the top element. */
    public int top() {
        int popped = 0;
        while(stack.peek()!=null){
            popped = stack.remove();
            sstack.add(popped);    
        }
        while(sstack.peek()!=null){
            stack.add(sstack.remove());    
        }
        return popped;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.peek()==null;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
