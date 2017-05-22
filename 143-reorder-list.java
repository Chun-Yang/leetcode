/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public void reorderList(ListNode head) {
    // length is 0
    if (head == null) return;

    int counter = 0;
    // # reverse
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      counter++;
      slow = slow.next;
      fast = fast.next.next;
    }

    // length is 1 or 2
    if (fast == slow) return;
    ListNode s = slow;

    ListNode rightHat = slow;
    ListNode rightHead = slow.next;
    while (rightHead.next != null) {
      ListNode nextRightNeck = rightHead.next.next;
      rightHead.next.next = rightHat.next;
      rightHat.next = rightHead.next;
      rightHead.next = nextRightNeck;
    }

    // # merge
    ListNode start = head;
    for (int i=0; i<counter; i++) {
      ListNode nextRightHead = rightHat.next.next;
      rightHat.next.next = start.next;
      start.next = rightHat.next;
      rightHat.next = nextRightHead;
      start = start.next.next;
    }
  }
}
