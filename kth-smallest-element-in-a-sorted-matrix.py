import itertools
class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        n = len(matrix)
        def countle(val):
            count, j = 0, n - 1
            for i in range(n):
                while j >= 0 and matrix[i][j] > val:
                    j -= 1
                count += j + 1
            return count

        lo, hi = matrix[0][0], matrix[-1][-1]
        while lo < hi:
            mid = (lo + hi) // 2
            count = countle(mid)
            if count < k:
                lo = mid + 1
            else:
                hi = mid

        return lo

# Solution().kthSmallest([[1,5,9],[10,11,13],[12,13,15]], 8)
