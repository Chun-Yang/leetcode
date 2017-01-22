# Definition for a  binary tree node
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
        self.root = TreeNode(None)
        self.root.left = TreeNode(None)
        self.root.right = root
        self.positions = [self.root, self.root.left]
        self.next()

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.positions) > 1


    def next(self):
        """
        :rtype: int
        """
        value = self.positions[-1].val

        # navigate to the next element
        ## go up
        while self.positions[-2].right == self.positions[-1]:
            if len(self.positions) == 1:
                return value
            self.positions.pop()

        ## go down
        self.positions.pop()
        self.positions.append(self.positions[-1].right)
        while self.positions[-1]:
            self.positions.append(self.positions[-1].left)
        self.positions.pop()

        return value

# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())
