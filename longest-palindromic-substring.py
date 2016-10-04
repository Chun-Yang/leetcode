class Solution(object):
    def longestWithCenter(self, padded_s, i):
        length = 0
        while padded_s[i - length - 1] == padded_s[i + length + 1]:
            length += 1

        # print("i", i)
        # print("length", length)
        # string = padded_s[
        #         i - length:
        #         i + length + 1
        #         ]
        # print("string", string)

        return length

    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) == 0:
            return s

        padded_s = '^#' + '#'.join(list(s)) + '#$'
        # NOTE: the length is real, the string is padded

        padded_len = len(padded_s)
        longest_center = 1
        longest_length = 0

        for i in range(1, len(padded_s) - 1):
            length = self.longestWithCenter(padded_s, i)
            if length > longest_length:
                longest_length = length
                longest_center = i

        longest_string = ''.join(filter(
            lambda x: x != '#',
            list(padded_s[
                longest_center - longest_length:
                longest_center + longest_length + 1
            ])
        ))

        # print("longest_string", longest_string)

        return longest_string


# assert Solution().longestPalindrome('abba') == 'abba'
# assert Solution().longestPalindrome('ccd') == 'cc'
