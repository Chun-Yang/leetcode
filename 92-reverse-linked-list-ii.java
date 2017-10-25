// Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
//
//
// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
//
// return 1->4->3->2->5->NULL.
//
//
// Note:
// Given m, n satisfy the following condition:
// 1 ≤ m ≤ n ≤ length of list.


// https://leetcode.com/problems/reverse-linked-list-ii

// solution2:
// get pointer to the hat of m
// move n - 1 node between the hat and the head
class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode hat = new ListNode(0);
    hat.next = head;
    ListNode reversedHat = hat;
    for (int i=0; i<m-1; i++) reversedHat = reversedHat.next;
    ListNode reversedHead = reversedHat.next;
    ListNode reversedEnd = reversedHat.next;
    for (int i=0; i<n-m; i++) {
      ListNode nextHead = reversedEnd.next;

      reversedEnd.next = reversedEnd.next.next;
      nextHead.next = reversedHead;
      reversedHat.next = nextHead;

      reversedHead = nextHead;
    }
    return hat.next;
  }
}

// solution1:
// get pointer to the hat of m
// get pointer to the tail of n
// use another pointer to hold the reversed mn
// put mn back between hat and tail


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// class Solution {
//   public ListNode reverseBetween(ListNode head, int m, int n) {
//     ListNode hat = new ListNode(0);
//     hat.next = head;

//     ListNode hatOfStart = hat;
//     for (int i=1; i<m; i++) hatOfStart = hatOfStart.next;

//     ListNode tailOfEnd = head;
//     for (int i=0; i<n; i++) tailOfEnd = tailOfEnd.next;

//     ListNode reversedEnd = hatOfStart.next;
//     ListNode reversedHat = new ListNode(0);
//     ListNode iter = hatOfStart.next;
//     while (iter != tailOfEnd) {
//       ListNode nextIter = iter.next;
//       iter.next = reversedHat.next;
//       reversedHat.next = iter;
//       iter = nextIter;
//     }

//     hatOfStart.next = reversedHat.next;
//     reversedEnd.next = tailOfEnd;

//     return hat.next;
//   }
// }
