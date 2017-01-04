class NumMatrix(object):
    def __init__(self, matrix):
        """
        initialize your data structure here.
        :type matrix: List[List[int]]
        """
        if not matrix:
            return
        m, n = len(matrix), len(matrix[0])
        squareSums = [[0 for j in range(n + 1)] for i in range(m + 1)]
        for i in range(m):
            for j in range(n):
                squareSums[i + 1][j + 1] = \
                        squareSums[i + 1][j] + \
                        squareSums[i][j + 1] - \
                        squareSums[i][j] + \
                        matrix[i][j]
        self.squareSums = squareSums

    def sumRegion(self, row1, col1, row2, col2):
        """
        sum of elements matrix[(row1,col1)..(row2,col2)], inclusive.
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        if not self.squareSums:
            return 0
        return self.squareSums[row2 + 1][col2 + 1] + \
                self.squareSums[row1][col1] - \
                self.squareSums[row1][col2 + 1] - \
                self.squareSums[row2 + 1][col1]

# Your NumMatrix object will be instantiated and called as such:
# numMatrix = NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]])
# [
#         [3,0,1,4,2],
#         [5,6,3,2,1],
#         [1,2,0,1,5],
#         [4,1,0,1,7],
#         [1,0,3,0,5]
#         ]
# assert numMatrix.sumRegion(2,1,4,3) == 8
# numMatrix.sumRegion(1,1,2,2)
# numMatrix.sumRegion(1,2,2,4)
