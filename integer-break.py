class Solution(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [0, 1, 1]

        for i in range(3, n + 1):
            val = 0
            for j in range(1, i // 2 + 1):
                val = max(val, max(dp[j], j) * max(dp[i - j], i - j))
            dp.append(val)

        return dp[-1]

# Solution().integerBreak(3)
