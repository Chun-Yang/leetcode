# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reorderList(self, head):
        if not head or not head.next:
            return

        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        def reverseList(head):
            tail = None
            while head:
                current = head
                head = head.next
                current.next = tail
                tail = current
            return tail

        left = head.next
        right = reverseList(slow.next)
        slow.next = None

        while right:
            head.next = right
            right = right.next

            head.next.next = left
            left = left.next

            head = head.next.next
