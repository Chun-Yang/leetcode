class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        size = len(s)
        start, end = 0, 0

        isPalindrome = [ [ False for j in range(size) ] for i in range(size) ]

        for l in range(1, size + 1):
            for i in range(0, size - l + 1):
                # test [i, j]
                j = i + l - 1
                if s[i] == s[j] and (i + 1 > j - 1 or isPalindrome[i + 1][j - 1]):
                    isPalindrome[i][j] = True
                    start, end = i, j

        return s[start:end + 1]

# assert Solution().longestPalindrome('') == ''
# assert Solution().longestPalindrome('a') == 'a'
# assert Solution().longestPalindrome('aa') == 'aa'
# assert Solution().longestPalindrome('ab') == 'b'
# assert Solution().longestPalindrome('aab') == 'aa'
# assert Solution().longestPalindrome('aabb') == 'bb'
# assert Solution().longestPalindrome('abade') == 'aba'
# assert Solution().longestPalindrome('deaba') == 'aba'
# assert Solution().longestPalindrome('aaaa') == 'aaaa'
# assert Solution().longestPalindrome('aaaaa') == 'aaaaa'
# assert Solution().longestPalindrome('babad') == 'aba'
