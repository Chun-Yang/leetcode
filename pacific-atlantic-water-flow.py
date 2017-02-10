class Solution(object):
    def pacificAtlantic(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        m = len(matrix)
        if m == 0:
            return []
        n = len(matrix[0])
        if n == 0:
            return []

        atlantic = [ [ False for j in range(n) ] for i in range(m) ]
        pacific = [ [ False for j in range(n) ] for i in range(m) ]

        atlanticBoundary = set((m - 1, j) for j in range(n)) | \
                set((i, n - 1) for i in range(m))
        for i, j in atlanticBoundary:
            atlantic[i][j] = True
        pacificBoundary = set((0, j) for j in range(n)) | \
                set((i, 0) for i in range(m))
        for i, j in pacificBoundary:
            pacific[i][j] = True

        def bfs(ocean, bd):
            if not bd:
                return
            for i, j in list(bd):
                if i > 0 and not ocean[i-1][j] and matrix[i-1][j] >= matrix[i][j]:
                    ocean[i-1][j] = True
                    bd.add((i-1, j))
                if j > 0 and not ocean[i][j-1] and matrix[i][j-1] >= matrix[i][j]:
                    ocean[i][j-1] = True
                    bd.add((i, j-1))
                if i < m - 1 and not ocean[i+1][j] and matrix[i+1][j] >= matrix[i][j]:
                    ocean[i+1][j] = True
                    bd.add((i+1, j))
                if j < n - 1 and not ocean[i][j+1] and matrix[i][j+1] >= matrix[i][j]:
                    ocean[i][j+1] = True
                    bd.add((i, j+1))
                bd.remove((i, j))

            bfs(ocean, bd)

        bfs(atlantic, atlanticBoundary)
        bfs(pacific, pacificBoundary)

        res = []
        for i in range(m):
            for j in range(n):
                if atlantic[i][j] and pacific[i][j]:
                    res.append([i, j])
        return res
