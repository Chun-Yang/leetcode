/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }
public class Solution {
  public ListNode sortList(ListNode head) {
    int length = 0;
    ListNode node = head;
    while (node != null) {
      length++;
      node = node.next;
    }
    if (length <= 1) return head;

    int half = 1;
    ListNode hat = new ListNode(0);
    hat.next = head;

    // this loop is for doubling half
    ListNode hatEnd;
    ListNode nextStart;
    ListNode firstStart;
    ListNode firstEnd;
    ListNode secondStart;
    ListNode secondEnd;

    while (half < length) {
      hatEnd = hat;
      nextStart = hat.next;
      while (nextStart != null) {
        firstStart = nextStart;
        firstEnd = nextStart;
        for (int i=0; i<half-1; i++) {
          if (firstEnd.next == null) break;
          firstEnd = firstEnd.next;
        }
        secondStart = firstEnd.next;
        // only have first half
        if (secondStart == null) {
          hatEnd.next = firstStart;
          break;
        }

        // have second half
        firstEnd.next = null;
        secondEnd = secondStart;
        for (int i=0; i<half-1; i++) {
          if (secondEnd.next == null) break;
          secondEnd = secondEnd.next;
        }
        //   preserve nextStart
        nextStart = secondEnd.next;
        secondEnd.next = null;

        // merge
        while (firstStart != null || secondStart != null) {
          if (firstStart == null) {
            hatEnd.next = secondStart;
            secondStart = secondStart.next;
          } else if (secondStart == null) {
            hatEnd.next = firstStart;
            firstStart = firstStart.next;
          } else if (firstStart.val < secondStart.val) {
            hatEnd.next = firstStart;
            firstStart = firstStart.next;
          } else {
            hatEnd.next = secondStart;
            secondStart = secondStart.next;
          }
          hatEnd = hatEnd.next;
        }
      }
      half = half * 2;
    }

    return hat.next;
  }
}
