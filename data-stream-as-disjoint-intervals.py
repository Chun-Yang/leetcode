# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e
from bisect import bisect_left

class SummaryRanges(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.intervals = []

    def addNum(self, val):
        """
        :type val: int
        :rtype: void
        """
        if len(self.intervals) == 0:
            self.intervals.append([val, val])
            return

        index = bisect_left(self.intervals, [val, val])
        if index == 0:
            if self.intervals[0][0] - val > 1:
                self.intervals.insert(index, [val, val])
            elif self.intervals[0][0] - val == 1:
                self.intervals[0][0] -= 1
        elif index == len(self.intervals):
            if val - self.intervals[-1][1] > 1:
                self.intervals.insert(index, [val, val])
            elif val - self.intervals[-1][1] == 1:
                self.intervals[-1][1] += 1
        elif self.intervals[index-1][0] <= val <= self.intervals[index-1][1] \
                or self.intervals[index][0] <= val <= self.intervals[index][1]:
            return
        elif self.intervals[index][0] - self.intervals[index-1][1] == 2:
            right = self.intervals[index][1]
            del self.intervals[index]
            self.intervals[index-1][1] = right
        elif val - self.intervals[index-1][1] == 1:
            self.intervals[index-1][1] += 1
        elif self.intervals[index][0] - val == 1:
            self.intervals[index][0] -= 1
        else:
            self.intervals.insert(index, [val, val])


    def getIntervals(self):
        """
        :rtype: List[Interval]
        """
        return [Interval(s, e) for s, e in self.intervals]


# Your SummaryRanges object will be instantiated and called as such:
# obj = SummaryRanges()
# obj.addNum(val)
# param_2 = obj.getIntervals()
