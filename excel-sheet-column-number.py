class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        res, base = 0, ord('A')
        for c in s:
            res = res * 26 + ord(c) - base + 1
        return res
