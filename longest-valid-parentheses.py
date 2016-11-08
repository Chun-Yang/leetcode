import collections

class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """

        pendings = collections.deque()
        beforeStart = -1
        maxLen = 0

        for i in range(len(s)):
            if s[i] == '(':
                pendings.append(i)
            elif not pendings:
                beforeStart = i
            else:
                j = pendings.pop()
                if pendings:
                    maxLen = max(maxLen, i - pendings[-1])
                else:
                    maxLen = max(maxLen, i - beforeStart)

        return maxLen
