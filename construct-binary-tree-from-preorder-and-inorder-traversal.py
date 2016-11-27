# import sys
# sys.setrecursionlimit(10)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """

        l = len(preorder)

        def build(pS, pE, iS, iE):
            # print("pS, pE, iS, iE", pS, pE, iS, iE)
            if pS > pE:
                return None
            root = TreeNode(preorder[pS])
            offset = inorder.index(preorder[pS]) - iS
            root.left = build(pS + 1, pS + offset, iS, iS + offset - 1)
            root.right = build(pS + offset + 1, pE, iS + offset + 1, iE)
            return root

        return build(0, l - 1, 0, l - 1)

# Solution().buildTree([1,2], [2,1])
# Solution().buildTree([1,2,3], [3,2,1])
