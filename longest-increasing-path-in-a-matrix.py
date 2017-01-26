class Solution(object):
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        m = len(matrix)
        if m == 0:
            return 0
        n = len(matrix[0])
        if n == 0:
            return 0

        dp = [ [ 0 for i in range(n) ] for i in range(m) ]

        def dfs(i, j):
            if dp[i][j] > 0:
                return dp[i][j]
            up, down, left, right = 0, 0, 0, 0
            if i > 0 and matrix[i][j] < matrix[i - 1][j]:
                up = dfs(i - 1, j)
            if i < m - 1 and matrix[i][j] < matrix[i + 1][j]:
                down = dfs(i + 1, j)
            if j > 0 and matrix[i][j] < matrix[i][j - 1]:
                left = dfs(i, j - 1)
            if j < n - 1 and matrix[i][j] < matrix[i][j + 1]:
                right = dfs(i, j + 1)
            dp[i][j] = max([up, down, left, right]) + 1
            return dp[i][j]

        for i in range(m):
            for j in range(n):
                dfs(i, j)

        return max(max(row) for row in dp)

# Solution().longestIncreasingPath([[9,9,4],[6,6,8],[2,1,1]])
