package leetcode;

public class CircularQueue {

	int f = 0; //front index
	int r = -1; //rear index
	int k = 0; //length of queue
	int count = 0; //total no. of elements present in queue

	int[] queue;

	/** Initialize your data structure here. Set the size of the queue to be k. */
	public CircularQueue(int k) {
		this.k = k;
		queue = new int[k]; //create a queue of size k
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
			r = (r + 1) % k; //circular increment rear index
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
			f = (f + 1) % k; //circular increment front index
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
