# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        hat = ListNode(0)
        hat.next = head
        lo = hi = hat
        for i in range(n):
            hi = hi.next
        while hi.next:
            lo = lo.next
            hi = hi.next
        lo.next = lo.next.next
        return hat.next
