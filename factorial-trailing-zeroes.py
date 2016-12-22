class Solution(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        res = 0
        while n > 0:
            n //= 5
            res += n

        return res

# 1
# 1 2 3 4 5 6 7 8 9 10
#         *          *
