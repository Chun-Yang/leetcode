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
        values = []
        def preorder(node):
            if node is None:
                values.append(None)
            else:
                values.append(node.val)
                preorder(node.left)
                preorder(node.right)

        preorder(root)
        return ','.join('' if v is None else str(v) for v in values)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        nodes = data.split(',')
        counter = [0]

        def preorder():
            if nodes[counter[0]] == '':
                counter[0] += 1
                return None
            else:
                node = TreeNode(int(nodes[counter[0]]))
                counter[0] += 1
                node.left = preorder()
                node.right = preorder()
                return node

        return preorder()


# Your Codec object will be instantiated and called as such:
# root = TreeNode(1)
# codec = Codec()
# codec.deserialize(codec.serialize(root))
