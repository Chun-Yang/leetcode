# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        vals = []

        def preOrder(node):
            if node:
                vals.append(node.val)
                preOrder(node.left)
                preOrder(node.right)

        preOrder(root)

        return ' '.join(map(str, vals))

    # O( N ) since each val run build once
    def deserialize(self, data):
        vals = collections.deque(int(val) for val in data.split())

        def build(minVal, maxVal):
            if vals and minVal < vals[0] < maxVal:
                val = vals.popleft()
                node = TreeNode(val)
                node.left = build(minVal, val)
                node.right = build(val, maxVal)
                return node

        return build(float('-infinity'), float('infinity'))

    # O( N*log(N) )
    # def deserialize(self, data):
    #     if data == '':
    #         return None

    #     def insert(node, val):
    #         if val < node.val:
    #             if node.left is None:
    #                 node.left = TreeNode(val)
    #             else:
    #                 insert(node.left, val)
    #         else:
    #             if node.right is None:
    #                 node.right = TreeNode(val)
    #             else:
    #                 insert(node.right, val)

    #     vals = [int(val) for val in data.split(' ')]

    #     root = TreeNode(vals[0])

    #     for val in vals[1:]:
    #         insert(root, val)

    #     return root


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
