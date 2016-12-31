# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0

        h, node = 0, root
        while node:
            h, node = h + 1, node.left

        # binary search to get the count of last layer
        lastFull = 2 ** (h - 1)
        lo, hi = 1, lastFull + 1
        while lo < hi:
            mid = (lo + hi) // 2
            midTemp = mid
            node = root
            half = lastFull // 2
            for i in range(h - 1):
                if midTemp > half:
                    midTemp -= half
                    node = node.right
                else:
                    node = node.left
                half = half // 2

            if node:
                lo = mid + 1
            else:
                hi = mid

        return 2 ** (h - 1) - 1 + lo - 1
