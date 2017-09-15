// Given a non-negative number represented as a singly linked list of digits,
// plus one to the number.

// The digits are stored such that the most significant digit is at the head of
// the list.

// Example:
// Input:
// 1->2->3

// Output:
// 1->2->4

// Solution1: recursive
class Solution {
  public LinkedNode plusOneLinkedList(LinkedNode head) {
    boolean carry = plusOne(head);
    if (carry) {
      LinkedNode newHead = new LinkedNode(1);
      newHead.next = node;
      return newHead;
    }
    return head;
  }
  private boolean plusOne(LinkedNode node) {
    boolean carry = node.next == null || plusOne(node.next);
    node.val = (node.val + carry) % 10;
    return node.val == 0;
  }
}
// Solution2: https://discuss.leetcode.com/topic/49603/two-pointers-java-solution-o-n-time-o-1-space
