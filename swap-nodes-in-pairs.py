# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        hat = ListNode(0)
        node = hat

        while head and head.next:
            node.next, node.next.next, head = head.next, head, head.next.next
            node = node.next.next

        node.next = head
        return hat.next
