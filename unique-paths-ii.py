class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])

        paths = [ [ 0 for j in range(n) ] for i in range(m) ]
        paths[m - 1][n - 1] = 1 - obstacleGrid[m - 1][n - 1]
        for i in reversed(range(m - 1)):
            if not obstacleGrid[i][n - 1]:
                paths[i][n - 1] = paths[i + 1][n - 1]
        for j in reversed(range(n - 1)):
            if not obstacleGrid[m - 1][j]:
                paths[m - 1][j] = paths[m - 1][j + 1]

        for i in reversed(range(m - 1)):
            for j in reversed(range(n - 1)):
                if not obstacleGrid[i][j]:
                    paths[i][j] = paths[i + 1][j] + paths[i][j + 1]

        return paths[0][0]

# assert Solution().uniquePathsWithObstacles([[0,0], [0,0]]) == 2
