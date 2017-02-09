# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def dfs(node, isLeft):
            if not node:
                return 0
            elif not node.left and not node.right:
                return node.val if isLeft else 0
            else:
                return dfs(node.left, True) + dfs(node.right, False)

        return dfs(root, False)
