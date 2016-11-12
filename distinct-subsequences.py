class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        lens = len(s)
        lent = len(t)

        cache = [[None] * lent for i in range(lens)]

        def count(i, j):
            if j == lent:
                return 1

            if i == lens:
                return 0

            if cache[i][j] is not None:
                return cache[i][j]

            if lens - i < lent - j:
                return 0

            k = s[i:].find(t[j])
            if k == -1:
                cache[i][j] = 0
            else:
                cache[i][j] = count(i + k + 1, j + 1) + count(i + k + 1, j)

            return cache[i][j]

        return count(0, 0)

# assert Solution().numDistinct('', 'a') == 0
# assert Solution().numDistinct('b', 'b') == 1
# assert Solution().numDistinct("bit", "it") == 1
# assert Solution().numDistinct("rabbbit", "rabbit") == 3
# Solution().numDistinct("anacondastreetracecar", "contra")
