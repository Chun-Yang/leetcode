from heapq import heappush, heappop

class Solution(object):
    def trapRainWater(self, heightMap):
        """
        :type heightMap: List[List[int]]
        :rtype: int
        """
        m = len(heightMap)
        if m <= 2:
            return 0

        n = len(heightMap[0])
        if n <= 2:
            return 0

        amount = 0
        boundary = []
        visited = [ [False for j in range(n)] for i in range(m) ]
        for i in range(1, m - 1):
            heappush(boundary, (heightMap[i][0], i, 0))
            heappush(boundary, (heightMap[i][n-1], i, n-1))
            visited[i][0] = True
            visited[i][n-1] = True
        for j in range(1, n - 1):
            heappush(boundary, (heightMap[0][j], 0, j))
            heappush(boundary, (heightMap[m-1][j], m-1, j))
            visited[0][j] = True
            visited[m-1][j] = True

        while boundary:
            height, i, j = heappop(boundary)
            if i == 0:
                candidates = [[i+1, j]]
            elif i == m - 1:
                candidates = [[i-1, j]]
            elif j == 0:
                candidates = [[i, j+1]]
            elif j == n - 1:
                candidates = [[i, j-1]]
            else:
                candidates = [
                        [i+1, j],
                        [i-1, j],
                        [i, j+1],
                        [i, j-1]
                        ]
            for ci, cj in candidates:
                if not visited[ci][cj]:
                    cHeight = heightMap[ci][cj]
                    amount += max(0, height - cHeight)
                    heappush(boundary, (max(height, cHeight), ci, cj))
                    visited[ci][cj] = True

        return amount

# heightMap = [
#           [1,4,3,1,3,2],
#           [3,2,1,3,2,4],
#           [2,3,3,2,3,1]
#         ]
# Solution().trapRainWater(heightMap)
