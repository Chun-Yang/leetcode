class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        n = len(matrix)
        if n == 0:
            return []

        m = len(matrix[0])
        if m == 0:
            return []

        spiral = []
        left, right, up, down = 0, m - 1, 0, n - 1

        while left <= right and up <= down:
            for j in range(left, right + 1):
                spiral.append(matrix[up][j])
            for i in range(up + 1, down + 1):
                spiral.append(matrix[i][right])
            if up != down:
                for j in reversed(range(left, right)):
                    spiral.append(matrix[down][j])
            if left != right:
                for i in reversed(range(up + 1, down)):
                    spiral.append(matrix[i][left])

            left += 1
            right -= 1
            up += 1
            down -= 1

        return spiral

# assert Solution().spiralOrder([[1,2],[4,3]]) == [1,2,3,4]
# assert Solution().spiralOrder([[1,2,3],[4,5,6]]) == [1,2,3,6,5,4]
# assert Solution().spiralOrder([[2,3]]) == [2,3]
