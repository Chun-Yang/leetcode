# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        l, node = 0, head
        while node:
            node, l = node.next, l + 1

        if l == 0:
            return head

        k = k % l
        if k == 0:
            return head

        preNewHead, newHead = None, head
        for i in range(l - k):
            newHead, preNewHead = newHead.next, newHead
        preNewHead.next = None

        middle = newHead
        for i in range(k - 1):
            middle = middle.next

        middle.next = head

        return newHead
