class Solution(object):
    def findPoisonedDuration(self, timeSeries, duration):
        """
        :type timeSeries: List[int]
        :type duration: int
        :rtype: int
        """
        endTime = - float('inf')
        total = 0
        for t in timeSeries:
            if t >= endTime:
                total += duration
            else:
                total += t + duration - endTime
            endTime = t + duration

        return total
