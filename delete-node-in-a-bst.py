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
        def isLeaf(node):
            return node and not node.left and not node.right

        # return leaf value and remove leaf
        def deleteLeaf(root):
            if isLeaf(root.left):
                val = root.left.val
                root.left = None
                return val
            elif isLeaf(root.right):
                val = root.right.val
                root.right = None
                return val
            elif root.left:
                return deleteLeaf(root.left)
            else:
                return deleteLeaf(root.right)

        def sink(root):
            val = root.val
            if root.left and val < root.left.val:
                root.val = root.left.val
                root.left.val = val
                sink(root.left)
            elif root.right and val > root.right.val:
                root.val = root.right.val
                root.right.val = val
                sink(root.right)

        def delete(root):
            leafVal = deleteLeaf(root)
            root.val = leafVal
            sink(root)
            return root

        def find(node, key):
            if node is None:
                return None
            elif key < node.val:
                node.left = find(node.left, key)
            elif key > node.val:
                node.right = find(node.right, key)
            elif node.left is None and node.right is None:
                return None
            else:
                return delete(node)

            return node

        return find(root, key)
