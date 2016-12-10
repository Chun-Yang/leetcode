from collections import Counter

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        counts = Counter(s).values()
        extra = 1 if any(c % 2 == 1 for c in counts) else 0
        return sum(c if c % 2 == 0 else ( c - 1 ) for c in counts) + extra
