/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var rotateRight = function(head, k) {
  if (!head) {
    return head
  }

  // get length
  let length = 1
  let end = head
  while (end.next) {
    end = end.next
    length++
  }

  k = k % length

  // no rotation
  if (k === 0) {
    return head
  }

  let newEnd = head
  for (let i=0; i<(length - k) - 1; i++) {
    newEnd = newEnd.next
  }

  const newHead = newEnd.next
  end.next = head
  newEnd.next = null

  return newHead
};
