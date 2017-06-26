/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public boolean isPalindrome(ListNode head) {
    if (head == null) return true;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode reversedHat = new ListNode(0);
    while (slow != null) {
      ListNode nextSlow = slow.next;
      slow.next = reversedHat.next;
      reversedHat.next = slow;
      slow = nextSlow;
    }
    ListNode reversedHead = reversedHat.next;
    while (reversedHead != null) {
      if (head.val != reversedHead.val) return false;
      head = head.next;
      reversedHead = reversedHead.next;
    }
    return true;
  }
}
