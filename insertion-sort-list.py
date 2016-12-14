# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def insertionSortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        ordered = cur = ListNode(0)

        while head:
            unplaced, head = head, head.next
            if cur.val > unplaced.val:
                cur = ordered
            while cur.next and cur.next.val < unplaced.val:
                cur = cur.next
            cur.next, cur.next.next = unplaced, cur.next

        return ordered.next
