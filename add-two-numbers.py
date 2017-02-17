# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        lSum = head = ListNode(0)
        carry = 0
        while l1 or l2:
            v1, v2 = 0, 0

            if l1:
                v1, l1 = l1.val, l1.next
            if l2:
                v2, l2 = l2.val, l2.next

            carry, v = divmod(v1 + v2 + carry, 10)
            lSum.next = ListNode(v)
            lSum = lSum.next

        if carry:
            lSum.next = ListNode(1)

        return head.next
