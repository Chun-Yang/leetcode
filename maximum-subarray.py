class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        acc = 0
        maxSum = float('-inf')
        for num in nums:
            maxSum = max(num + acc, maxSum)
            acc = max(num + acc, 0)
        return maxSum
