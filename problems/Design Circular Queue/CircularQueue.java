package leetcode;

public class CircularQueue {

	int f = 0;
	int r = -1;
	int k = 0;
	int count = 0;

	int[] queue;

	/** Initialize your data structure here. Set the size of the queue to be k. */
	public CircularQueue(int k) {
		this.k = k;
		queue = new int[k];
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean enQueue(int value) {
		if (isFull())
			return false;
		else {
			count++;
			r = (r + 1) % k;
			queue[r] = value;
			return true;
		}
	}

	/**
	 * Delete an element from the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean deQueue() {
		if (isEmpty())
			return false;
		else {
			count--;
			f = (f + 1) % k;
			return true;
		}
	}

	/** Get the front item from the queue. */
	public int Front() {
		if (!isEmpty())
			return queue[f];
		else
			return -1;
	}

	/** Get the last item from the queue. */
	public int Rear() {
		if (!isEmpty())
			return queue[r];
		else
			return -1;
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		if (count == 0)
			return true;
		else
			return false;
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		if (count == k)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int value = 3;
		int k = 3;
		CircularQueue circularQueue = new CircularQueue(3); // set the size to be 3
		System.out.println(circularQueue.enQueue(1)); // return true
		System.out.println(circularQueue.enQueue(2)); // return true
		System.out.println(circularQueue.enQueue(3)); // return true
		System.out.println(circularQueue.enQueue(4)); // return false, the queue is full
		System.out.println(circularQueue.Rear()); // return 3
		System.out.println(circularQueue.isFull()); // return true
		System.out.println(circularQueue.deQueue()); // return true
		System.out.println(circularQueue.enQueue(4)); // return true
		System.out.println(circularQueue.Rear()); // return 4

	}

}
