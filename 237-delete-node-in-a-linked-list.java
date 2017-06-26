/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  // public void deleteNode(ListNode node) {
  //   node.val = node.next.val;
  //   if (node.next.next == null) node.next = null;
  //   else deleteNode(node.next);
  // }
  public void deleteNode(ListNode node) {
    while (node.next.next != null) {
      node.val = node.next.val;
      node = node.next;
    }
    node.val = node.next.val;
    node.next = null;
  }
}
