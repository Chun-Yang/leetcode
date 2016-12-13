class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head

        oddHead, evenHead = head, head.next
        oddLast, evenLast = head, head.next
        node = head.next.next
        while True:
            if node is None:
                break

            oddLast.next = node
            oddLast = node
            evenLast.next = node.next
            evenLast = node.next

            if node.next is None:
                break

            node = node.next.next

        oddLast.next = evenHead
        return oddHead


# # Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# root = ListNode(1)
# root.next = ListNode(2)
# root.next.next = ListNode(3)
# Solution().oddEvenList(root)
