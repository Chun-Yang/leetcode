import bisect

class Solution(object):
    def findRightInterval(self, intervals):
        starts = sorted([I.start, i] for i, I in enumerate(intervals)) + [[float('inf'), -1]]
        return [starts[bisect.bisect(starts, [I.end])][1] for I in intervals]

# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

# Solution().findRightInterval([Interval(i[0], i[1]) for i in [[1,2],[2,3],[0,1],[3,4]]])
