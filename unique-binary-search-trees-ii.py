# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """
        if n == 0:
            return []

        def generate(start, end):
            if start > end:
                return [None]

            trees = []
            for i in range(start, end + 1):
                for left in generate(start, i - 1):
                    for right in generate(i + 1, end):
                        tree = TreeNode(i)
                        tree.left = left
                        tree.right = right
                        trees.append(tree)
            return trees

        return generate(1, n)

# Solution().generateTrees(0)
