### 232. Implement Queue using Stacks
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.<br>
pop() -- Removes the element from in front of queue.<br>
peek() -- Get the front element.<br>
empty() -- Return whether the queue is empty.<br>

#### Example:

MyQueue queue = new MyQueue();

queue.push(1);<br>
queue.push(2);  <br>
queue.peek();  // returns 1<br>
queue.pop();   // returns 1<br>
queue.empty(); // returns false<br>

#### Notes:

You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
