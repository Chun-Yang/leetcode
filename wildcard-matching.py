class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        i, j, iLast ,jStar, lens, lenp = 0, 0, None, None, len(s), len(p)

        while True:
            if i == lens:
                return all(c == '*' for c in p[j:])

            shouldGoBack = j == lenp or not (p[j] == '*' or p[j] == '?' or p[j] == s[i])
            if shouldGoBack:
                canGoBack = iLast is not None
                if canGoBack:
                    i = iLast + 1
                    j = jStar + 1
                    iLast += 1
                else:
                    return False
            else:
                if p[j] == '*':
                    iLast = i
                    jStar = j
                    j += 1
                else:
                    i += 1
                    j += 1


# assert Solution().isMatch('aa', 'a') == False
# assert Solution().isMatch('a', '*a*') == True
# assert Solution().isMatch('b', '*?*?') == False
# assert Solution().isMatch("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab", "***bba**a*bbba**aab**b") == False
