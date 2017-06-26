public class MyQueue {
  Stack<Integer> stack;

  /** Initialize your data structure here. */
  public MyQueue() {
    stack = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    Stack<Integer> reversedStack = new Stack<>();
    while (!stack.isEmpty()) reversedStack.push(stack.pop());

    Stack<Integer> nextStack = new Stack<>();
    nextStack.push(x);
    while (!reversedStack.isEmpty()) nextStack.push(reversedStack.pop());

    stack = nextStack;
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    return stack.pop();
  }

  /** Get the front element. */
  public int peek() {
    return stack.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return stack.isEmpty();
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
