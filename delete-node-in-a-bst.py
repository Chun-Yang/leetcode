# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def deleteNode(self, root, key):
        """
        :type root: TreeNode
        :type key: int
        :rtype: TreeNode
        """
        def findMax(root):
            node = root
            while node.right:
                node = node.right
            return node.val

        def delete(root, key):
            if root is None:
                return None
            elif key < root.val:
                root.left = delete(root.left, key)
                return root
            elif key > root.val:
                root.right = delete(root.right, key)
                return root
            elif root.left is None and root.right is None:
                return None
            elif root.left is None:
                return root.right
            elif root.right is None:
                return root.left
            else:
                maxInLeft = findMax(root.left)
                root.val = maxInLeft
                root.left = delete(root.left, maxInLeft)
                return root

        return delete(root, key)
