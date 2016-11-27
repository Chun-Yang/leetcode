class Solution(object):
    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        m = len(matrix)
        n = len(matrix[0])
        dp = [ [None for j in range(n)] for i in range(m) ]

        dp[m - 1][n - 1] = (1, 1, (1, 1), (1, 1))

        for i in reversed(range(m - 1)):
            if matrix[i][n - 1] == matrix[i + 1][n - 1]:
                l = 1 + dp[i + 1][n - 1][1]
                dp[i][n - 1] = (1, l, (1, 1), (1, l))
            else:
                dp[i][n - 1] = (1, 1, (1, 1), (1, 1))

        for j in reversed(range(n - 1)):
            if matrix[m - 1][j] == matrix[m - 1][j + 1]:
                k = 1 + dp[m - 1][j + 1][0]
                dp[m - 1][j] = (k, 1, (k, 1), (1, 1))
            else:
                dp[m - 1][j] = (1, 1, (1, 1), (1, 1))

        for i in reversed(range(m - 1)):
            for j in reversed(range(n - 1)):
                k, l, p, q, x, y = 1, 1, 1, 1, 1, 1
                if matrix[i][j] == matrix[i][j + 1]:
                    k = dp[i][j + 1][0] + 1

                if matrix[i][j] == matrix[i + 1][j]:
                    l = dp[i + 1][j][1] + 1

                if matrix[i][j] == matrix[i + 1][j + 1]:
                    p, q = dp[i + 1][j + 1][2]
                    q += 1
                    q = min(q, l)
                    if q == 1:
                        p = k
                    else:
                        p = min(p + 1, k)

                    x, y = dp[i + 1][j + 1][3]
                    x += 1
                    x = min(x, k)
                    if x == 1:
                        y = l
                    else:
                        y = min(y + 1, l)
                else:
                    p, q, x, y = k, 1, 1, l


                dp[i][j] = (k, l, (p, q), (x, y))

        area = 0
        for i in range(m):
            for j in range(n):
                l, k, (p, q), (x, y) = dp[i][j]
                area = max(max(l, k ,p * q, x * y), area)

        return area

# matrix = [
#         [1, 0, 1, 0, 0,],
#         [1, 0, 1, 1, 1,],
#         [1, 1, 1, 1, 1,],
#         [1, 0, 0, 1, 0,],
#         ]

# print("Solution().maximalRectangle(matrix)", Solution().maximalRectangle(matrix))
