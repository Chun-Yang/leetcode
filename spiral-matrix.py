class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        # termination condition: rlo (row lo) > math.ceil(n / 2.0)
