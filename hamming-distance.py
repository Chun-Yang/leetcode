class Solution(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        distance = 0
        while x > 0 or y > 0:
            distance += ((x & 1) != (y & 1))
            x >>= 1
            y >>= 1
        return distance
