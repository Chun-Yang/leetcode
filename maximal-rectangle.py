# https://discuss.leetcode.com/topic/6650/share-my-dp-solution

class Solution(object):
    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        m = len(matrix)
        if m < 1:
            return 0

        n = len(matrix[0])
        if n < 1:
            return 0

        area = 0
        left, right, height = [0] * n, [n] * n, [0] * n

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    height[j] += 1
                else:
                    height[j] = 0

            curLeft = 0
            for j in range(n):
                if matrix[i][j] == '1':
                    left[j] = max(left[j], curLeft)
                else:
                    left[j], curLeft = 0, j + 1

            curRight = n
            for j in reversed(range(n)):
                if matrix[i][j] == '1':
                    right[j] = min(right[j], curRight)
                else:
                    right[j], curRight = n, j

            for j in range(n):
                area = max(area, (right[j] - left[j]) * height[j])

        return area
