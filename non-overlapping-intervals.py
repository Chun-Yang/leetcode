# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        rightBoundary = -float('inf')
        count = 0
        for left, right in sorted([i.start, i.end] for i in intervals):
            if left < rightBoundary:
                count += 1
                rightBoundary = min(rightBoundary, right)
            else:
                rightBoundary = right

        return count
