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
        inclusiveMax = 0
        exclusiveMax = 0
        currentLayer = [root] if root else []
        while currentLayer:
            currentSum = sum(node.val for node in currentLayer)
            inclusiveMax, exclusiveMax = \
                    currentSum + exclusiveMax, max(inclusiveMax, exclusiveMax)

            nextLayer = []
            for node in currentLayer:
                if node.left:
                    nextLayer.append(node.left)
                if node.right:
                    nextLayer.append(node.right)

            currentLayer = nextLayer

        return max(inclusiveMax, exclusiveMax)
