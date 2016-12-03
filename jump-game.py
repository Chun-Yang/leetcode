class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        l = len(nums)
        dp = [False] * l
        dp[-1] = True
        for i in reversed(range(l - 1)):
            j = i + 1
            while j < min(i + nums[i] + 1, l):
                if dp[j]:
                    dp[i] = True
                    break
                j += nums[j] + 1

        return dp[0]
