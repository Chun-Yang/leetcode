class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if not needle:
            return 0
        haystackSize, needleSize = len(haystack), len(needle)
        for i in range(haystackSize - needleSize + 1):
            if haystack[i:i + needleSize] == needle:
                return i
        return -1
