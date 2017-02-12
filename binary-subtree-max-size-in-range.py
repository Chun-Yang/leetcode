class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# # v1.0
# # @return [maxSize, isSubTree]
def isSubTreeAndSize(node, minVal, maxVal):
    if node is None:
        return [0, True]
    elif node.val < minVal:
        return [isSubTreeAndSize(node.right, minVal, maxVal)[0], False]
    elif node.val > maxVal:
        return [isSubTreeAndSize(node.left, minVal, maxVal)[0], False]
    else:
        leftSize, leftIsSubTree = isSubTreeAndSize(node.left, minVal, maxVal)
        rightSize, rightIsSubTree = isSubTreeAndSize(node.right, minVal, maxVal)
        if leftIsSubTree and rightIsSubTree:
            return [leftSize + rightSize + 1, True]
        else:
            return [max(leftSize, rightSize), False]

def binarySubtreeMaxSizeInRange(root, minVal, maxVal):
    value = isSubTreeAndSize(root, minVal, maxVal)[0]
    return value

tree1 = None
assert binarySubtreeMaxSizeInRange(tree1, 0, 10) == 0
tree2 = TreeNode(4)
assert binarySubtreeMaxSizeInRange(tree2, 0, 10) == 1
tree3 = TreeNode(5)
tree3.left = TreeNode(2)
tree3.right = TreeNode(8)
assert binarySubtreeMaxSizeInRange(tree3, 0, 10) == 3
tree4 = TreeNode(5)
tree4.left = TreeNode(2)
tree4.left.left = TreeNode(-1)
tree4.right = TreeNode(8)
tree4.right.right = TreeNode(11)
assert binarySubtreeMaxSizeInRange(tree4, 0, 10) == 0
tree5 = TreeNode(5)
tree5.left = TreeNode(2)
tree5.left.right = TreeNode(4)
tree5.right = TreeNode(8)
tree5.right.right = TreeNode(11)
assert binarySubtreeMaxSizeInRange(tree5, 0, 10) == 2
