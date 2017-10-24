// Given a sorted linked list, delete all duplicates such that each element
// appear only once.
//
//
// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.


// https://leetcode.com/problems/remove-duplicates-from-sorted-list

// solution1: pointer
public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode iter = head;
    while (iter != null && iter.next != null) {
      if (iter.val == iter.next.val) iter.next = iter.next.next;
      else iter = iter.next;
    }
    return head;
  }
}
