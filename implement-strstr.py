class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        lh, ln = len(haystack), len(needle)
        for i in range(lh - ln + 1):
            if haystack[i:i+ln] == needle:
                return i
        return -1
