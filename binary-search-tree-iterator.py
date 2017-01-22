# # Definition for a  binary tree node
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.root = root
        self.positions = []
        node = self.root
        while node:
            self.positions.append(node)
            node = node.left

    def hasNext(self):
        """
        :rtype: bool
        """
        return bool(self.positions)

    def next(self):
        """
        :rtype: int
        """

        value = self.positions[-1].val

        if self.positions[-1].right:
            node = self.positions[-1].right
            while node:
                self.positions.append(node)
                node = node.left
            return value

        node = self.positions.pop()
        while self.positions and self.positions[-1].right == node:
            node = self.positions.pop()

        return value


# Your BSTIterator will be called like this:
# root = TreeNode(1)
# root.right = TreeNode(2)
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())
# print("v", v)
