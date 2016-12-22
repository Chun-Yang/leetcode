class Solution(object):
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        res, a = '', ord('A')
        while True:
            n, digit = divmod(n, 26)
            if digit > 0:
                res = chr(a + digit - 1) + res
            elif n > 0:
                res = 'Z' + res
                n -= 1
            else:
                return res

# Solution().convertToTitle(28)
