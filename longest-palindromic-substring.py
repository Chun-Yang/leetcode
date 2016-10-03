class Solution(object):
    def __init__(self):
        self.memoization = {}

    def isPalindrome(self, s):
        if s in self.memoization:
            return self.memoization[s]

        is_palindrome = len(s) <= 1 or (s[0] == s[-1] and self.isPalindrome(s[1: -1]))
        self.memoization[s] = is_palindrome
        return is_palindrome

    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if self.isPalindrome(s):
            return s
        else:
            first_half = self.longestPalindrome(s[1:])
            second_half = self.longestPalindrome(s[:-1])
            return first_half if (len(first_half) > len(second_half)) else second_half


assert Solution().longestPalindrome('abba') == 'abba'
