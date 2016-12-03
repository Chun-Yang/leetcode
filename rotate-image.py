class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        n1 = n - 1
        for i in range(n // 2):
            for j in range(n // 2):
                matrix[i][j],    matrix[j][n1-i], matrix[n1-i][n1-j], matrix[n1-j][i] = \
                matrix[n1-j][i], matrix[i][j],    matrix[j][n1-i],    matrix[n1-i][n1-j],

        if n % 2 == 1:
            j = n // 2
            for i in range(n // 2):
                matrix[i][j],    matrix[j][n1-i], matrix[n1-i][n1-j], matrix[n1-j][i] = \
                matrix[n1-j][i], matrix[i][j],    matrix[j][n1-i],    matrix[n1-i][n1-j],

# matrix = [[1,2], [3,4]]
# Solution().rotate(matrix)
# print("matrix", matrix)
