from collections import defaultdict

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        start, length, indexes = 0, 0, defaultdict(lambda: -1)
        for i, c in enumerate(s):
            start = max(start, indexes[c] + 1)
            length = max(i - start + 1, length)
            indexes[c] = i
        return length

# assert Solution().lengthOfLongestSubstring('') == 0
# assert Solution().lengthOfLongestSubstring('a') == 1
# assert Solution().lengthOfLongestSubstring('abcde') == 5
# assert Solution().lengthOfLongestSubstring('aaaaa') == 1
# assert Solution().lengthOfLongestSubstring('aabbcc') == 2
# assert Solution().lengthOfLongestSubstring('ababab') == 2
# assert Solution().lengthOfLongestSubstring('dvdf') == 3
