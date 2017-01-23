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
        lead = TreeNode(0)
        lead.left = TreeNode(0)
        lead.right = root
        values, path = [], [lead, lead.left]

        while True:
            cur = path.pop()
            values.append(cur.val)

            if not path:
                return values[1:-1]

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
