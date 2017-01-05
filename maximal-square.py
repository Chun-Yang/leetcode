class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        m = len(matrix)
        if m == 0:
            return 0

        n = len(matrix[0])
        maxWidth = 0
        pre = [(0, 0, 0)] * (n + 1)
        for row in matrix:
            cur = [(0, 0, 0)] * (n + 1)
            for i, num in enumerate(row):
                if row[i] == '1':
                    width = cur[i][0] + 1
                    height = pre[i + 1][1] + 1
                    square = min(pre[i][2] + 1, width, height)
                    cur[i + 1] = (width, height, square)
                    maxWidth = max(maxWidth, cur[i + 1][2])
            pre = cur

        return maxWidth * maxWidth

# Solution().maximalSquare(["1101","1101","1111"])
# Solution().maximalSquare(["10100","10111","11111","10010"])
