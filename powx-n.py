class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        res, base, isPositive, n = 1, x, n >= 0, abs(n)
        while n > 0:
            if 1 & n:
                res *= base
            base *= base
            n = n >> 1

        return res if isPositive else 1 / res

# Solution().myPow(3,5)
