# # v1.0
# class Solution(object):
#     def longestPalindrome(self, s):
#         """
#         :type s: str
#         :rtype: str
#         """
#         size = len(s)
#         start, end = 0, 0

#         isPalindrome = [ [ False for j in range(size) ] for i in range(size) ]

#         for l in range(1, size + 1):
#             for i in range(0, size - l + 1):
#                 # test [i, j]
#                 j = i + l - 1
#                 if s[i] == s[j] and (i + 1 > j - 1 or isPalindrome[i + 1][j - 1]):
#                     isPalindrome[i][j] = True
#                     start, end = i, j

#         return s[start:end + 1]

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s:
            return s

        end, maxLen = len(s) - 1, 1

        for i in range(len(s)):
            if i - maxLen >= 0 and s[i-maxLen:i+1] == s[i-maxLen:i+1][::-1]:
                end = i
                maxLen += 1
            elif i - maxLen -1 >= 0 and s[i-maxLen-1:i+1] == s[i-maxLen-1:i+1][::-1]:
                end = i
                maxLen += 2

        return s[end + 1 - maxLen:end + 1]

assert Solution().longestPalindrome('') == ''
assert Solution().longestPalindrome('a') == 'a'
assert Solution().longestPalindrome('aa') == 'aa'
assert Solution().longestPalindrome('ab') == 'b'
assert Solution().longestPalindrome('aab') == 'aa'
assert Solution().longestPalindrome('aabbb') == 'bbb'
assert Solution().longestPalindrome('abade') == 'aba'
assert Solution().longestPalindrome('deaba') == 'aba'
assert Solution().longestPalindrome('aaaa') == 'aaaa'
assert Solution().longestPalindrome('aaaaa') == 'aaaaa'
assert Solution().longestPalindrome('babad') in ['aba', 'bab']
