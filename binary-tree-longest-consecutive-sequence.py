class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# # v1.0
# def longestSequence(node, longestSize=0, currentSize=0, preValue=float('inf')):
#     if node is None:
#         return max(longestSize, currentSize)
#     elif node.val == preValue + 1:
#         return max(
#                 longestSequence(node.left, longestSize, currentSize + 1, node.val),
#                 longestSequence(node.right, longestSize, currentSize + 1, node.val)
#                 )
#     else:
#         longestSize = max(longestSize, currentSize)
#         return max(
#                 longestSequence(node.left, longestSize, 1, node.val),
#                 longestSequence(node.right, longestSize, 1, node.val)
#                 )

# # v2.0
# def longestSequence(node, currentSize=0, preValue=float('inf')):
#     if node is None:
#         return currentSize
#     elif node.val == preValue + 1:
#         return max(
#                 longestSequence(node.left, currentSize + 1, node.val),
#                 longestSequence(node.right, currentSize + 1, node.val)
#                 )
#     else:
#         return max(
#                 currentSize,
#                 longestSequence(node.left, 1, node.val),
#                 longestSequence(node.right, 1, node.val)
#                 )

# tree1 = None
# assert longestSequence(tree1) == 0
# tree2 = TreeNode(2)
# assert longestSequence(tree2) == 1
# tree3 = TreeNode(2)
# tree3.left = TreeNode(3)
# tree3.right = TreeNode(4)
# assert longestSequence(tree3) == 2
# tree4 = TreeNode(2)
# tree4.left = TreeNode(3)
# tree4.left.left = TreeNode(5)
# tree4.right = TreeNode(3)
# tree4.right.right = TreeNode(4)
# assert longestSequence(tree4) == 3
# tree5 = TreeNode(2)
# tree5.left = TreeNode(3)
# tree5.left.right = TreeNode(4)
# tree5.right = TreeNode(8)
# tree5.right.right = TreeNode(11)
# assert longestSequence(tree5) == 3

# v3.0
def longestConsecutive(node, parents=[]):
    if node is None:
        return parents
    elif parents and node.val == parents[-1] + 1:
        return max(
                [
                    longestConsecutive(node.left, parents + [node.val]),
                    longestConsecutive(node.right, parents + [node.val])
                ],
                key=len
                )
    else:
        return max(
                [
                    longestConsecutive(node.left, [node.val]),
                    longestConsecutive(node.right, [node.val]),
                    parents
                ],
                key=len
                )

# tree1 = None
# assert longestConsecutive(tree1) == []
tree2 = TreeNode(2)
assert longestConsecutive(tree2) == [2]
tree3 = TreeNode(2)
tree3.left = TreeNode(3)
tree3.right = TreeNode(4)
assert longestConsecutive(tree3) == [2,3]
tree4 = TreeNode(2)
tree4.left = TreeNode(3)
tree4.left.left = TreeNode(5)
tree4.right = TreeNode(3)
tree4.right.right = TreeNode(4)
assert longestConsecutive(tree4) == [2,3,4]
tree5 = TreeNode(2)
tree5.left = TreeNode(3)
tree5.left.right = TreeNode(4)
tree5.right = TreeNode(8)
tree5.right.right = TreeNode(11)
assert longestConsecutive(tree5) == [2,3,4]
