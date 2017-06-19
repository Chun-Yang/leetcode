/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode reversedHead = null;

    while (head != null) {
      ListNode nextReversedHead = head;
      head = head.next;
      nextReversedHead.next = reversedHead;
      reversedHead = nextReversedHead;
    }

    return reversedHead;
  }

  // // NOTE: recersive
  // public ListNode reverseList(ListNode head) {
  //   return reverse(head, null);
  // }
  // private ListNode reverse(ListNode unReversed, ListNode reversed) {
  //   if (unReversed == null) return reversed;
  //   ListNode reservedNext = unReversed;
  //   unReversed = unReversed.next;
  //   reservedNext.next = reversed;
  //   return reverse(unReversed, reservedNext);
  // }
}
