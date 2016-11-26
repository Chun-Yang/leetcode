class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        l = len(triangle)
        dp = list(triangle[-1])
        for i in reversed(range(l - 1)):
            for j in range(i + 1):
                dp[j] = triangle[i][j] + min(dp[j], dp[j+1])

        return dp[0]

# triangle = [
#         [2],
#         [3,4],
#         [6,5,7],
#         [4,1,8,3]
#         ]
# assert Solution().minimumTotal(triangle) == 11
