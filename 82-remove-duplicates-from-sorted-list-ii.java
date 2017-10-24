// Given a sorted linked list, delete all nodes that have duplicate numbers,
// leaving only distinct numbers from the original list.
//
//
// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.


// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
// solution1: pointers, first, second and third

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode hat = new ListNode(0);
    hat.next = head;
    ListNode iter = hat;
    while (iter != null && iter.next != null && iter.next.next != null) {
      if (iter.next.val == iter.next.next.val) {
        int val = iter.next.val;
        while(iter.next != null && iter.next.val == val) {
          iter.next = iter.next.next;
        }
      } else {
        iter = iter.next;
      }
    }
    return hat.next;
  }
  // public ListNode deleteDuplicates(ListNode head) {
  //   if (head == null || head.next == null) return head;

  //   ListNode hat = new ListNode(0);
  //   hat.next = head;
  //   ListNode first = hat;
  //   ListNode second = first.next;
  //   ListNode third = second.next;
  //   while (true) {
  //     if (second.val == third.val) {
  //       while(third != null && third.val == second.val) {
  //         third = third.next;
  //       }
  //       first.next = third;
  //     } else {
  //       first = second;
  //     }

  //     if (first == null || first.next == null || first.next.next == null) {
  //       return hat.next;
  //     } else {
  //       second = first.next;
  //       third = second.next;
  //     }
  //   }
  // }
}
