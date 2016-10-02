class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = 0
        current_chars = {}
        for index, char in enumerate(s):
            if char in current_chars:
                current_length = len(current_chars)
                if current_length > length:
                    length = current_length

                beginning_index = current_chars[char]
                current_chars = {s[i]: i for i in range(beginning_index + 1, index + 1)}
            else:
                current_chars[char] = index

        return max(length, len(current_chars))

# assert Solution().lengthOfLongestSubstring("abcabcbb") == 3
# assert Solution().lengthOfLongestSubstring("bbbbb") == 1
# assert Solution().lengthOfLongestSubstring("pwwkew") == 3
