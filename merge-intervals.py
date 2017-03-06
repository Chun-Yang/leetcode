# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

# class Solution(object):
#     def merge(self, intervals):
#         """
#         :type intervals: List[Interval]
#         :rtype: List[Interval]
#         """
#         if not intervals:
#             return []

#         sortedIntervals = sorted(intervals, key=lambda i: i.start)
#         mergedIntervals = [sortedIntervals[0]]

#         for cur in sortedIntervals[1:]:
#             pre = mergedIntervals[-1]
#             preStart, preEnd = pre.start, pre.end
#             curStart, curEnd = cur.start, cur.end
#             if curStart > preEnd:
#                 mergedIntervals.append(cur)
#             elif curEnd > preEnd:
#                 mergedIntervals[-1].end = curEnd

#         return mergedIntervals

# BST
class Solution(object):
    def merge(self, intervals):
        ## insert
        ## @return (Node, left, right)
        ## Node: [Interval, Node, Node]
        def insert(node, newI, merged):
            if node is None:
                return None if merged else [newI, None, None]

            curI = node[0]

            # no overlap, on the left side
            if newI.end < curI.start:
                node[1] = insert(node[1], newI, merged)
            # no overlap, on the right size
            elif newI.start > curI.end:
                node[2] = insert(node[2], newI, merged)
            # overlap
            else:
                # extends left
                if newI.start < curI.start:
                    curI.start = newI.start
                    leftNode = insert(node[1], newI, True)
                    # should merge
                    if leftNode and leftNode[0].end >= curI.start:
                        curI.start = min(leftNode[0].start, curI.start)
                        node[1] = leftNode[1]
                    else:
                        node[1] = leftNode
                # extends right
                if newI.end > curI.end:
                    curI.end = newI.end
                    rightNode = insert(node[2], newI, True)
                    # should merge
                    if rightNode and rightNode[0].start <= curI.end:
                        curI.end = max(rightNode[0].end, curI.end)
                        node[2] = rightNode[2]
                    else:
                        node[2] = rightNode
                if merged:
                    if newI.start > curI.start:
                        return node[1]
                    if newI.end < curI.end:
                        return node[2]
                    return None
            return node

        root = None
        for i in intervals:
            root = insert(root, i, False)

        ## inorder to get saperate intervals
        mergedIntervals = []
        def inorder(node):
            if node is None:
                return
            inorder(node[1])
            mergedIntervals.append(node[0])
            inorder(node[2])

        inorder(root)
        return mergedIntervals
