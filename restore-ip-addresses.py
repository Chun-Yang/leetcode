import re

class Solution(object):
    def restoreIpAddresses(self, string):
        """
        :type s: str
        :rtype: List[str]
        """
        def isAllowed(s):
            if not s:
                return False
            if s[0] == '0':
                return s == '0'
            return int(s) < 256

        def dfs(prefix, size, s):
            if size == 1:
                return [prefix + [s]] if isAllowed(s) else []

            ans = []
            for i in range(3):
                if isAllowed(s[:i+1]):
                    ans += dfs(prefix + [s[:i+1]], size - 1, s[i+1:])

            return ans

        return list(map(lambda x: '.'.join(x), dfs([], 4, string)))

# assert Solution().restoreIpAddresses('0000') == ['0.0.0.0']
