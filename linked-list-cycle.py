# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        fast = head
        slow = head
        while True:
            if fast is None or fast.next is None:
                return False
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                return True
