# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[Interval]
        :type newInterval: Interval
        :rtype: List[Interval]
        """
        res = []
        isUsed = False
        left = newInterval.start
        right = newInterval.end
        for interval in intervals:
            if interval.end < newInterval.start:
                res.append(interval)
            elif interval.start > newInterval.end:
                if not isUsed:
                    res.append(Interval(left, right))
                    isUsed = True
                res.append(interval)
            else:
                left = min(left, interval.start)
                right = max(right, interval.end)

        if not isUsed:
            res.append(Interval(left, right))

        return res
