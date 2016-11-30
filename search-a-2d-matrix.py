class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m = len(matrix)
        if m == 0:
            return False

        n = len(matrix[0])
        if n == 0:
            return False

        lo, hi = 0, m
        while lo < hi:
            mid = lo + (hi - lo) // 2
            if matrix[mid][0] > target:
                hi = mid
            elif matrix[mid][0] < target:
                lo = mid + 1
            else:
                return True

        row, lo, hi = hi - 1, 0, n
        while lo < hi:
            mid = lo + (hi - lo) // 2
            if matrix[row][mid] > target:
                hi = mid
            elif matrix[row][mid] < target:
                lo = mid + 1
            else:
                return True

        return False

# assert Solution().searchMatrix([[1]], 2) == False
# assert Solution().searchMatrix([[1]], 1) == True
# assert Solution().searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,50]], 3) == True
