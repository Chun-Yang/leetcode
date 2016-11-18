class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        padded = nums + [1]
        lenNums = len(nums)
        dp = [[None] * lenNums for i in range(lenNums)]

        def coins(lo, hi):
            if lo > hi:
                return 0

            if dp[lo][hi] is not None:
                return dp[lo][hi]

            maxValue = 0
            for i in range(lo, hi + 1):
                left = coins(lo, i - 1)
                right = coins(i + 1, hi)
                current = left + right + padded[i] * padded[lo - 1] * padded[hi + 1]
                maxValue = max(maxValue, current)

            dp[lo][hi] = maxValue
            return maxValue

        return coins(0, lenNums - 1)

# assert Solution().maxCoins([3, 1, 5]) == 35
# assert Solution().maxCoins([3, 1, 5, 8]) == 167
