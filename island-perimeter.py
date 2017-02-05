class Solution(object):
    def islandPerimeter(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        n = len(grid)
        if n == 0:
            return 0

        m = len(grid[0])
        if m == 0:
            return 0

        perimeter = 0

        for i in range(n):
            for j in range(m):
                if grid[i][j] == 0:
                    continue
                if i == 0 or grid[i-1][j] == 0:
                    perimeter += 1
                if i == (n-1) or grid[i+1][j] == 0:
                    perimeter += 1
                if j == 0 or grid[i][j-1] == 0:
                    perimeter += 1
                if j == (m-1) or grid[i][j+1] == 0:
                    perimeter += 1

        return perimeter
