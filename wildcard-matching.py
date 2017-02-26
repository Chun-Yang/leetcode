class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        ls, lp = len(s), len(p)
        matchMatrix = [ [ False for _ in range(lp + 1) ] for _ in range(ls + 1) ]

        matchMatrix[0][0] = True

        for j in range(1, lp + 1):
            if p[j-1] == '*':
                matchMatrix[0][j] = True
            else:
                break

        for i in range(1, ls + 1):
            for j in range(1, lp + 1):
                if s[i-1] == p[j-1] or p[j-1] == '?':
                    matchMatrix[i][j] = matchMatrix[i-1][j-1]
                elif p[j-1] == '*':
                    matchMatrix[i][j] = any(matchMatrix[k][j-1] for k in range(i+1))

        return matchMatrix[-1][-1]

# assert Solution().isMatch('aa', 'a*')
# assert Solution().isMatch('a', 'a*')
# assert Solution().isMatch('c', '*?*')
