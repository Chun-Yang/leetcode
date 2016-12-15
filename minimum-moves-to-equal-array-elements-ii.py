import statistics

class Solution(object):
    def minMoves2(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        median = statistics.median(nums)
        return int(sum(abs(num - median) for num in nums))
