# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        if not intervals:
            return []

        intervals = sorted(intervals, key=lambda i: i.start)

        res = []
        left, right = intervals[0].start, intervals[0].end
        for i in range(len(intervals)):
            interval = intervals[i]
            start, end = interval.start, interval.end
            if right >= start:
                right = max(right, end)
            else:
                res.append(Interval(left, right))
                left, right = start, end

        res.append(Interval(left, right))

        return res
