class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        nIsNegative = n < 0
        n = abs(n)

        index = 1
        xes = [x]
        while (index << 1) <= n:
            xes.append(xes[-1] * xes[-1])
            index <<= 1

        value = 1
        while index > 0:
            if index <= n:
                value *= xes[-1]
                n -= index
            index >>= 1
            xes.pop()

        if nIsNegative:
            return 1 / value
        else:
            return value

# assert Solution().myPow(1, 10) == 1
# assert Solution().myPow(2, 3) == 8
# assert Solution().myPow(3, 0) == 1
