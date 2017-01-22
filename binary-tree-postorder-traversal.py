# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []

        values, path = [], []

        node = root
        while node:
            path.append(node)
            if node.left:
                node = node.left
            elif node.right:
                node = node.right
            else:
                break

        while True:
            cur = path.pop()
            values.append(cur.val)

            if not path:
                return values

            if path[-1].left == cur:
                node = path[-1].right
                while node:
                    path.append(node)
                    if node.left:
                        node = node.left
                    elif node.right:
                        node = node.right
                    else:
                        break
