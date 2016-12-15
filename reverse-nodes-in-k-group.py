# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if k <= 1:
            return head

        hat, hat.next, cur = ListNode(0), head, head
        prev = hat

        def shouldContinue(start):
            for i in range(k):
                if not start:
                    return False
                start = start.next
            return True

        while shouldContinue(prev.next):
            start = prev.next
            for i in range(k - 1):
                prev.next, start.next.next, start.next = start.next, prev.next, start.next.next

            prev = start

        return hat.next
