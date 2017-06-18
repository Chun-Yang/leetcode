/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode removeElements(ListNode head, int val) {
    ListNode hat = new ListNode(0);
    hat.next = head;

    ListNode pre = hat;
    while (pre != null && pre.next != null) {
      if (pre.next.val == val) {
        pre.next = pre.next.next;
      } else {
        pre = pre.next;
      }
    }

    return hat.next;
  }
}
