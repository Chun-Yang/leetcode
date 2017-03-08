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
        length = len(intervals)

        # find insertion index
        def search(compare):
            lo, hi = 0, length
            while lo < hi:
                mid = ( lo + hi ) // 2
                if compare(newInterval, intervals[mid]):
                    lo = mid + 1
                else:
                    hi = mid
            return lo

        leftIndex = search(lambda newI, curI: newI.start - curI.start >= 0)
        leftIsInsideRange = leftIndex > 0 and \
                intervals[leftIndex - 1].end >= newInterval.start
        rightIndex = search(lambda newI, curI: newI.end - curI.end > 0)
        rightIsInsideRange = rightIndex < length and \
                intervals[rightIndex].start <= newInterval.end

        # inside an interval
        if leftIndex > rightIndex:
            pass
        # no overlap
        elif leftIndex == rightIndex and not leftIsInsideRange and not rightIsInsideRange:
            intervals.insert(leftIndex, newInterval)
        # overlap
        else:
            if leftIsInsideRange:
                leftOverlapIndex = leftIndex - 1
                leftBoundary = intervals[leftIndex - 1].start
            else:
                leftOverlapIndex = leftIndex
                leftBoundary = newInterval.start

            if rightIsInsideRange:
                rightOverlapIndex = rightIndex + 1
                rightBoundary = intervals[rightIndex].end
            else:
                rightOverlapIndex = rightIndex
                rightBoundary = newInterval.end

            intervals[leftOverlapIndex:rightOverlapIndex] = \
                    [Interval(leftBoundary, rightBoundary)]
        return intervals

# def listsToIntervals(lists):
#     return [Interval(s, e) for s, e in lists]

# def intervalsToLists(intervals):
#     return [[i.start,i.end] for i in intervals]

# def test(inputList, newInterval, outputList):
#     assert intervalsToLists(Solution().insert(listsToIntervals(inputList), newInterval)) == outputList

# test([[1,2], [3,4], [9,10]], Interval(2.5, 2.6), [[1,2], [2.5, 2.6], [3,4], [9,10]])
# test([[1,2], [3,4], [9,10]], Interval(10.5, 11), [[1,2], [3,4], [9,10], [10.5, 11]])
# test([[1,2], [3,4], [9,10]], Interval(0, 1.5), [[0,2], [3,4], [9,10]])
# test([[1,2], [3,4], [9,10]], Interval(1, 2), [[1,2], [3,4], [9,10]])
# test([[1,2], [3,4], [9,10]], Interval(0, 6), [[0,6], [9,10]])
# test([[1,2], [3,4], [9,10]], Interval(0, 100), [[0, 100]])
