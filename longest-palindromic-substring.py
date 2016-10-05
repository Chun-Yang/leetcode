# https://www.youtube.com/watch?v=nbTSfrEfo6M

class Solution(object):
    def longestWithCharCenter(self, s, i, length):
        longest_length = 1
        for j in range(1, min(i + 1, length - i)):
            if s[i - j] == s[i + j]:
                longest_length += 2
            else:
                return longest_length

        return longest_length

    def longestWithDivCenter(self, s, i, length):
        longest_length = 0
        for j in range(1, min(i + 2, length - i)):
            if s[i - j + 1] == s[i + j]:
                longest_length += 2
            else:
                return longest_length

        return longest_length

    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        s_length = len(s)

        if len(s_length) == 0:
            return s

        longest_center = 0
        longest_length = 1

        main_char_center = 0
        main_dev_center = 0
        longests = [[0, 0]] * (s_length - 1)

        for i in range(len(s) - 1):
            length = self.longestWithCharCenter(s, i, s_length)
            if length > longest_length:
                longest_length = length
                longest_center = i
            length = self.longestWithDivCenter(s, i, s_length)
            if length > longest_length:
                longest_length = length
                longest_center = i

        offset = longest_length // 2

        if longest_length % 2 == 0:
            return s[
                longest_center - offset + 1:
                longest_center + offset + 1
            ]
        else:
            return s[
                longest_center - offset:
                longest_center + offset + 1
            ]


# assert Solution().longestPalindrome('abba') == 'abba'
# assert Solution().longestPalindrome('ccd') == 'cc'
