class MyCircularDeque {

    int l = -1, r = 0, k = 0;
    boolean pass = false;
    int[] queue;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        queue = new int[k];
        this.k = k;
        r = 0;
        l = (-1%k + k) % k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) return false;
        else {
            if(l == r)
                pass = true;
            queue[l] = value;
            l = ((l - 1) % k + k)%k;
            if(l == r) pass = !pass;
            return true;
        }
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) return false;
        else {
            if(l == r)
                pass = true;
            queue[r] = value;
            r = (r + 1) % k;
            if(l == r) pass = !pass;
            return true;
        }
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        else {            
            if(l == r)
                pass = false;
            l = (l + 1) % k;
            if(l == r) pass = !pass;
            return true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) return false;
        else {
            if(l == r)
                pass = false;
            r = ((r - 1) % k + k)%k;
            if(l == r) pass = !pass;
            return true;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) return -1;
        else return queue[(l+1)%k];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) return -1;
        else return queue[((r-1)%k + k)%k];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(pass == false && (l+1)%k == r){
            return true;
        } else return false;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(pass == true && (l+1)%k == r){
            return true;
        } else return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
