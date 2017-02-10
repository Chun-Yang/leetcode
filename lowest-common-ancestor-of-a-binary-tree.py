# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root == p or root == q:
            return root

        def dfs(node):
            if node is None:
                return [False, False, node]

            left = dfs(node.left)
            right = dfs(node.right)

            if node == p:
                if left[1] or right[1]:
                    return [True, True, node]
                else:
                    return [True, False, node]
            elif node == q:
                if left[0] or right[0]:
                    return [True, True, node]
                else:
                    return [False, True, node]
            elif left[0] and left[1]:
                return left
            elif right[0] and right[1]:
                return right
            else:
                return [
                        left[0] or right[0],
                        left[1] or right[1],
                        node
                        ]

        return dfs(root)[2]
