# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        def toBST(head):
            if not head:
                return None
            if not head.next:
                return TreeNode(head.val)
            if not head.next.next:
                root = TreeNode(head.val)
                root.right = TreeNode(head.next.val)
                return root

            prev, slow, fast = head, head.next, head.next.next
            while fast and fast.next:
                prev = slow
                slow = slow.next
                fast = fast.next.next
            prev.next = None

            root = TreeNode(slow.val)
            root.left = toBST(head)
            root.right = toBST(slow.next)
            return root

        return toBST(head)
