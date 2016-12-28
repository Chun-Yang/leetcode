# O(log(m+n) + m) where m is the shorter edge of the matrix and n is the longer one

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m, n = len(matrix), len(matrix[0])
        def search(xlo, xhi, ylo, yhi):
            if xlo > xhi or ylo > yhi:
                return False
            if xlo == xhi and ylo == yhi:
                return matrix[xlo][ylo] == target
            if matrix[xlo][ylo] > target or matrix[xhi][yhi] < target:
                return False

            xmid = (xlo + xhi) // 2
            if target < matrix[xmid][ylo]:
                return search(xlo, xmid - 1, ylo, yhi)
            if target > matrix[xmid][yhi]:
                return search(xmid + 1, xhi, ylo, yhi)

            yleft, yright, ymid = ylo, yhi, ylo
            while yleft < yright:
                ymid = (yleft + yright) // 2
                val = matrix[xmid][ymid]
                if val < target:
                    yleft = ymid + 1
                elif val > target:
                    yright = ymid
                else:
                    return True
            return  matrix[xmid][yleft] == target or \
                    search(xlo, xmid - 1, yleft, yhi) or \
                    search(xmid + 1, xhi, ylo, yleft - 1)

        return search(0, m-1, 0, n-1)

# Solution().searchMatrix([[1,2,3,4,5]], 2)
# Solution().searchMatrix([[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]], 15)
