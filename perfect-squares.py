class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        squares = [float('inf')] * (n + 1)
        squares[1] = 1
        for i in range(1, n + 1):
            j = 1
            while i > j * j:
                squares[i] = min(squares[i], squares[i - j * j] + 1)
                j += 1
            if i == j * j:
                squares[i] = 1

        return squares[n]

# Solution().numSquares(2)
