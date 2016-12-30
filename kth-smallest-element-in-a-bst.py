class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        def inorder(node, count):
            if not node:
                return None, count

            val, count = inorder(node.left, count)
            if val is not None:
                return val, count

            count += 1
            if count == k:
                return node.val, count

            return inorder(node.right, count)

        return inorder(root, 0)[0]

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# assert Solution().kthSmallest(TreeNode(1), 1) == 1
