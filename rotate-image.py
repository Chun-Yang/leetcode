class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        for i in range(n // 2):
            for j in range((n + 1) // 2):
                matrix[i][j], matrix[j][n-i-1], matrix[n-i-1][n-j-1], matrix[n-j-1][i] = \
                matrix[n-j-1][i], matrix[i][j], matrix[j][n-i-1], matrix[n-i-1][n-j-1]

# m1a = [
#         [1,2,3],
#         [4,5,6],
#         [7,8,9]
#         ]
# m1b = [
#         [7,4,1],
#         [8,5,2],
#         [9,6,3]
#         ]
# Solution().rotate(m1a)
# assert m1a == m1b
