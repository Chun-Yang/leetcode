class Solution(object):
    def repeatedSubstringPattern(self, str):
        """
        :type str: str
        :rtype: bool
        """
        patternSize, size = 1, len(str)
        for i in range(size):
            if str[i % patternSize] != str[i]:
                patternSize = i + (str[i] != str[0])

        return patternSize < size and (size % patternSize == 0)

# Solution().repeatedSubstringPattern("abacababacab")
