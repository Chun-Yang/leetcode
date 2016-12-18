class Solution(object):
    def countNumbersWithUniqueDigits(self, n):
        """
        :type n: int
        :rtype: int
        """
        n = min(10, n)
        base, res = 9, 1
        for i in range(n):
            res += base
            base *= (9 - i)

        return res
