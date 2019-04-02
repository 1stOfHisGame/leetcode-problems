class MyQueue {

    Stack<Integer> queue;
    Stack<Integer> squeue;
    /** Initialize your data structure here. */
    public MyQueue() {
        queue = new Stack<Integer>();
        squeue = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        queue.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!queue.isEmpty()){
            squeue.push(queue.pop());
        }
        int popped = squeue.pop();
        while(!squeue.isEmpty()){
            queue.push(squeue.pop());
        }
        return popped;
    }
    
    /** Get the front element. */
    public int peek() {
        while(!queue.isEmpty()){
            squeue.push(queue.pop());
        }
        int peeked = squeue.peek();
        while(!squeue.isEmpty()){
            queue.push(squeue.pop());
        }
        return peeked;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
