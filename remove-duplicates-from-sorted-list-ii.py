# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        hat = ListNode(0)
        prev, cur, hat.next = hat, head, head
        while cur and cur.next:
            if cur.val == cur.next.val:
                val, cur = cur.val, cur.next.next
                while cur and cur.val == val:
                    cur = cur.next
                prev.next = cur
            else:
                prev, cur = cur, cur.next

        return hat.next
