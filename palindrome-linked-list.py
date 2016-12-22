class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head:
            return True

        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        def reverseList(h):
            newHead = None
            while h:
                h.next, h, newHead = newHead, h.next, h
            return newHead

        left = head
        right = reverseList(slow)

        while left and right:
            if left.val != right.val:
                return False
            left, right = left.next, right.next

        return True

# # Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# head = ListNode(1)
# head.next = ListNode(2)
# assert Solution().isPalindrome(head) == False
