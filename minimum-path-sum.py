# 1. dijkstra's algorithm O(mn)
# 2. dynamic programming O(mn)
# 3. a * search

import heapq

class Solution(object):
    def minPathSum(self, grid):
        m = len(grid)
        if m == 0:
            return 0

        n = len(grid[0])
        if n == 0:
            return 0

        distTo = [ [float('inf') for j in range(n)] for i in range(m)]
        distTo[0][0] = grid[0][0]

        visited = [ [False for j in range(n)] for i in range(m)]

        # note: we do not need change in heapq,
        # we can just keep pushing and the smallest will win
        # (distance, (i, j))
        pq = [(grid[0][0], (0, 0))]

        while True:
            if not pq:
                return distTo[m-1][n-1]

            i, j = heapq.heappop(pq)[1]
            if visited[i][j]:
                continue

            visited[i][j] = True

            if (i, j) == (m - 1, n - 1):
                return distTo[m-1][n-1]

            if i < m - 1:
                down = distTo[i][j] + grid[i + 1][j]
                if down < distTo[i + 1][j]:
                    distTo[i + 1][j] = down
                    heapq.heappush(pq, (down, (i + 1, j)))

            if j < n - 1:
                right = distTo[i][j] + grid[i][j + 1]
                if right < distTo[i][j + 1]:
                    distTo[i][j + 1] = right
                    heapq.heappush(pq, (right, (i, j + 1)))

# assert Solution().minPathSum([[0]]) == 0
# assert Solution().minPathSum([[1,2], [1,1]]) == 3

# class Solution(object):
#     def minPathSum(self, grid):
#         """
#         :type grid: List[List[int]]
#         :rtype: int
#         """
#         m = len(grid)
#         if m == 0:
#             return 0

#         n = len(grid[0])
#         if n == 0:
#             return 0

#         dp = [ [None for j in range(n)] for i in range(m)]
#         dp[m-1][n-1] = grid[m-1][n-1]

#         for i in reversed(range(m - 1)):
#             dp[i][n-1] = dp[i+1][n-1] + grid[i][n-1]

#         for j in reversed(range(n - 1)):
#             dp[m-1][j] = dp[m-1][j+1] + grid[m-1][j]

#         for i in reversed(range(m - 1)):
#             for j in reversed(range(n - 1)):
#                 dp[i][j] = min(dp[i+1][j], dp[i][j+1]) + grid[i][j]

#         return dp[0][0]
