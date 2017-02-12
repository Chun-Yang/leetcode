class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        base = x
        res = 1
        isPositive = n > 0
        n = abs(n)
        while n:
            if n & 1:
                res *= base
            n >>= 1
            base *= base
        return res if isPositive else 1.0 / res

# assert Solution().myPow(1.9, 0) == 1
# assert Solution().myPow(3,5) == 3 ** 5
# assert Solution().myPow(1.5, 2) == 1.5 ** 2
