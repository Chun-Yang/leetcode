# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findFrequentTreeSum(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []

        frequencies = {}

        def dfs(node):
            if not node:
                return 0
            sumLeft = dfs(node.left)
            sumRight = dfs(node.right)
            sumAll = sumLeft + sumRight + node.val
            if sumAll in frequencies:
                frequencies[sumAll] += 1
            else:
                frequencies[sumAll] = 1
            return sumAll

        dfs(root)

        maxFrequency = max(frequencies.values())
        return [key for key in frequencies.keys() if maxFrequency == frequencies[key]]
