class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        size = len(s)
        lefts, length, maxLength = [], 0, 0
        for i, c in enumerate(s):
            if c == '(':
                lefts.append([i, length])
                length = 0
            elif not lefts:
                length = 0
            else:
                index, preLength = lefts.pop()
                length = preLength + (i - index + 1)
                maxLength = max(maxLength, length)

        return maxLength

# assert Solution().longestValidParentheses('') == 0
# assert Solution().longestValidParentheses('(') == 0
# assert Solution().longestValidParentheses(')') == 0
# assert Solution().longestValidParentheses('()') == 2
# assert Solution().longestValidParentheses(')(') == 0
# assert Solution().longestValidParentheses(')()') == 2
# assert Solution().longestValidParentheses('(()') == 2
