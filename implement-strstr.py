class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        for i, c in enumerate(haystack):
            if needle == c:
                return i
        return -1
