# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        def dfs(node):
            if node is None:
                return ''
            else:
                return str(node.val) + ' ' + dfs(node.left) + dfs(node.right)

        # NOTE: remove the last space
        return dfs(root)[:-1]

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if data == '':
            return None

        values = map(int, data.split(' '))
        rootValue = values[0]
        root = TreeNode(rootValue)
        def insert(node, value):
            if value < node.val:
                if node.left is None:
                    node.left = TreeNode(value)
                else:
                    insert(node.left, value)
            else:
                if node.right is None:
                    node.right = TreeNode(value)
                else:
                    insert(node.right, value)

        for value in values[1:]:
            insert(root, value)

        return root


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
