class Solution(object):
    def lastRemaining(self, n):
        """
        :type n: int
        :rtype: int
        """
        def last(n, leftToRight):
            if n == 1:
                return 1

            val = last(n // 2, not leftToRight) * 2
            if (not leftToRight) and (n % 2 == 0):
                val -= 1
            return val

        return last(n, True)
