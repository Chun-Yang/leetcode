// Given a list, rotate the list to the right by k places,
// where k is non-negative.
//
// For example:
// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.


// https://leetcode.com/problems/rotate-list


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// NOTE: has to count the length since it's possible k >> length
// solution1: Do not use hat
// class Solution {
//   public ListNode rotateRight(ListNode head, int k) {
//     if (head == null) return head;

//     // get length and end
//     int length = 1;
//     ListNode counter = head.next;
//     ListNode end = head;
//     while (counter != null) {
//       counter = counter.next;
//       end = end.next;
//       length++;
//     }

//     int skip = (length - k % length) % length;
//     if (skip == 0) return head;

//     ListNode nextEnd = head;
//     for (int i=0; i<skip-1; i++) nextEnd = nextEnd.next;

//     ListNode nextHead = nextEnd.next;
//     end.next = head;
//     nextEnd.next = null;

//     return nextHead;
//   }
// }

// solution2: use hat
class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) return head;

    // get length and end
    int length = 1;
    ListNode end = head;
    while (end.next != null) {
      end = end.next;
      length++;
    }

    int skip = (length - k % length) % length;
    if (skip == 0) return head;

    ListNode nextEnd = head;
    for (int i=0; i<skip-1; i++) nextEnd = nextEnd.next;

    ListNode nextHead = nextEnd.next;
    end.next = head;
    nextEnd.next = null;

    return nextHead;
  }
}
