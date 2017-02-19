class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        isNegative = (dividend < 0 and divisor > 0) or \
                (dividend > 0 and divisor < 0)
        dividend, divisor = abs(dividend), abs(divisor)
        q, d = 1, divisor
        while dividend >= d:
            q <<= 1
            d <<= 1

        quotient = 0
        while q:
            if dividend >= d:
                dividend -= d
                quotient += q
            q >>= 1
            d >>= 1

        r = - quotient if isNegative else quotient
        minInt, maxInt = - (1 << 31), ((1 << 31) - 1)
        if minInt <= r <= maxInt:
            return r
        else:
            return maxInt

# assert Solution().divide(10, 3) == 3
# assert Solution().divide(0, 3) == 0
# assert Solution().divide(200, 4) == 50
# assert Solution().divide(-200, 4) == -50
