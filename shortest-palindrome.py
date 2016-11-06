class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        # 1. find the longest palindrom prefix, get the length
        # 2. reverse the rest

        sReversed = s[::-1]

        # Longest Palindrome Length
        def lpl(s):
            for i in range(len(s), 0, -1):
                if s[:i] == sReversed[-i:]:
                    return i

        length = lpl(s)
        print("length", length)
        return s[length:][::-1] + s

# assert Solution().shortestPalindrome('a') == 'a'
# assert Solution().shortestPalindrome("aacecaaa") == "aaacecaaa"
