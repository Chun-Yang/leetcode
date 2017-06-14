/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int l1 = 0;
    int l2 = 0;
    ListNode cur;
    cur = headA;
    while (cur != null) {
      l1++;
      cur = cur.next;
    }
    cur = headB;
    while (cur != null) {
      l2++;
      cur = cur.next;
    }
    for (int i=0; i<l1 - l2; i++) headA = headA.next;
    for (int i=0; i<l2 - l1; i++) headB = headB.next;
    int l = Math.min(l1, l2);
    for (int i=0; i<l; i++) {
      if (headA == headB) return headA;
      headA = headA.next;
      headB = headB.next;
    }
    return null;
  }
}
