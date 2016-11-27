# import sys
# sys.setrecursionlimit(10)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# class Solution(object):
#     def buildTree(self, inorder, postorder):
#         """
#         :type inorder: List[int]
#         :type postorder: List[int]
#         :rtype: TreeNode
#         """
#         def build(inorder, postorder):
#             if not inorder:
#                 return None

#             root = TreeNode(postorder[-1])
#             mid = inorder.index(postorder[-1])
#             root.left = build(inorder[:mid], postorder[:mid])
#             root.right = build(inorder[mid + 1:], postorder[mid:-1])
#             return root

#         return build(inorder, postorder)

class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        l = len(inorder)

        def build(inorderS, inorderE, postorderS, postorderE):
            # print("inorderS, inorderE, postorderS, postorderE", inorderS, inorderE, postorderS, postorderE)
            if inorderS > inorderE or postorderS > postorderE:
                return None

            rootVal = postorder[postorderE]
            root = TreeNode(rootVal)

            mid = inorder.index(rootVal)
            offset = mid - inorderS

            root.left = build(inorderS, mid - 1, postorderS, postorderS + offset - 1)
            root.right = build(mid + 1, inorderE, postorderS + offset, postorderE - 1)
            return root

        return build(0, l - 1, 0, l - 1)

# Solution().buildTree([1,3,2], [3,2,1])
# Solution().buildTree([1,2,3,4,5,6], [3,2,6,5,4,1])
# Solution().buildTree([1,2,3,4], [3,2,4,1])
