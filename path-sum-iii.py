# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sumTarget):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        targets = []

        def dfs(node):
            if not node:
                return 0

            targets.append(sumTarget)
            count = targets.count(node.val)

            for i in range(len(targets)):
                targets[i] -= node.val

            count += dfs(node.left)
            count += dfs(node.right)

            for i in range(len(targets)):
                targets[i] += node.val

            targets.pop()
            return count

        return dfs(root)
