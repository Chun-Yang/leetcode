# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        fast = head
        slow = head
        while True:
            if fast is None or fast.next is None:
                return None
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                break

        finder = head
        while True:
            if finder == slow:
                break
            finder = finder.next
            slow = slow.next

        return finder
