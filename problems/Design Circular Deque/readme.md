### 641. Design Circular Deque

Design your implementation of the circular double-ended queue (deque).

#### Your implementation should support following operations:

MyCircularDeque(k): Constructor, set the size of the deque to be k.<br>
insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.<br>
insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.<br>
deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.<br>
deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.<br>
getFront(): Gets the front item from the Deque. If the deque is empty, return -1.<br>
getRear(): Gets the last item from Deque. If the deque is empty, return -1.<br>
isEmpty(): Checks whether Deque is empty or not. <br>
isFull(): Checks whether Deque is full or not.<br>
 

#### Example:

MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3<br>
circularDeque.insertLast(1);			// return true<br>
circularDeque.insertLast(2);			// return true<br>
circularDeque.insertFront(3);			// return true<br>
circularDeque.insertFront(4);			// return false, the queue is full<br>
circularDeque.getRear();  			// return 2<br>
circularDeque.isFull();				// return true<br>
circularDeque.deleteLast();			// return true<br>
circularDeque.insertFront(4);			// return true<br>
circularDeque.getFront();			// return 4<br>
 

#### Note:
All values will be in the range of [0, 1000].<br>
The number of operations will be in the range of [1, 1000].<br>
Please do not use the built-in Deque library.<br>
