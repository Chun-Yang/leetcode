# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rob(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        # post order
        # return two values: maxInclusive, maxExclusive
        def dfs(node):
            if not node:
                return 0, 0
            leftInclusive,  leftExclusive  = dfs(node.left)
            rightInclusive, rightExclusive = dfs(node.right)
            maxInclusive = leftExclusive + rightExclusive + node.val
            maxExclusive = max(leftExclusive, leftInclusive) \
                    + max(rightExclusive, rightInclusive)

            return maxInclusive, maxExclusive

        return max(dfs(root))
