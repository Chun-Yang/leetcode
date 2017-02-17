# '.' Matches any single character.
# '*' Matches zero or more of the preceding element.

# The matching should cover the entire input string (not partial).

class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        sSize, pSize = len(s), len(p)
        matchTable = [ [ False for j in range(pSize + 1) ] for i in range(sSize + 1) ]
        matchTable[0][0] = True

        for j in range(pSize):
            if p[j] == '*' and matchTable[0][j-1]:
                matchTable[0][j+1] = True

        for i in range(sSize):
            for j in range(pSize):
                if s[i] == p[j] or p[j] == '.':
                    matchTable[i+1][j+1] = matchTable[i][j]
                elif p[j] == '*':
                    if s[i] != p[j-1] and p[j-1] != '.':
                        matchTable[i+1][j+1] = matchTable[i+1][j-1]
                    else:
                        matchTable[i+1][j+1] = matchTable[i+1][j-1] \
                                or matchTable[i+1][j] \
                                or matchTable[i][j+1]

        return matchTable[-1][-1]

# assert Solution().isMatch('aa', '.*')
# assert Solution().isMatch("aab", "c*a*b")
