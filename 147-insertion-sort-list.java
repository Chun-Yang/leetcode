/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode insertionSortList(ListNode head) {
    ListNode hat = new ListNode(0);
    hat.next = head;

    ListNode pre = hat;
    ListNode cur = head;
    ListNode leftPre = hat;
    ListNode leftCur = head;

    while (cur != null) {
      ListNode next = cur.next;

      leftPre = hat;
      leftCur = hat.next;
      while (leftCur != cur && leftCur.val <= cur.val) {
        leftPre = leftPre.next;
        leftCur = leftCur.next;
      }

      if (leftCur != cur) {
        leftPre.next = cur;
        cur.next = leftCur;
        pre.next = next;
      } else {
        pre = pre.next;
      }

      cur = next;
    }

    return hat.next;
  }
}
