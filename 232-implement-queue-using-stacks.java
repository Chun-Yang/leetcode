// Implement the following operations of a queue using stacks.
//
//
// push(x) -- Push element x to the back of queue.
//
//
// pop() -- Removes the element from in front of queue.
//
//
// peek() -- Get the front element.
//
//
// empty() -- Return whether the queue is empty.
//
//
// Notes:
//
// You must use only standard operations of a stack
// which means only push to top, peek/pop from top, size, and is empty operations are valid.
// Depending on your language, stack may not be supported natively.
// You may simulate a stack by using a list or deque (double-ended queue),
// as long as you use only standard operations of a stack.
// You may assume that all operations are valid
// (for example, no pop or peek operations will be called on an empty queue).


// https://leetcode.com/problems/implement-queue-using-stacks

// solution1: two stacks
// - pushStack
// - popStack
// when the popStack is empty and we want to pop,
// we will move pushStack to popStack
// time O(1) amortized

// solution2: naive one stack
// - when push, we use two temporary stacks to reverse the list twice
// push(5) to 4,3,2,1
// reversedStack: 1,2,3,4
// nextStack: 5,4,3,2,1
// time O(n)

public class MyQueue {
  Stack<Integer> pushStack;
  Stack<Integer> popStack;

  /** Initialize your data structure here. */
  public MyQueue() {
    pushStack = new Stack<Integer>();
    popStack = new Stack<Integer>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    pushStack.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    populatePopStack();
    return popStack.pop();
  }

  /** Get the front element. */
  public int peek() {
    populatePopStack();
    return popStack.peek();
  }

  private void populatePopStack() {
    if (!popStack.isEmpty()) return;
    while (!pushStack.isEmpty()) popStack.push(pushStack.pop());
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return pushStack.isEmpty() && popStack.isEmpty();
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
