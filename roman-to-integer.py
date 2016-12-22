class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        values = { 'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000 }
        ans, prev = 0, 1
        for c in reversed(s):
            cur = values[c]
            ans += cur if cur >= prev else - cur
            prev = cur

        return ans

# assert Solution().romanToInt("MCMXCVI") == 1996
