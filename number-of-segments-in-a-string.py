class Solution(object):
    def countSegments(self, s):
        """
        :type s: str
        :rtype: int
        """
        wasSpace, count = True, 0
        for c in s:
            isSpace = c == ' '
            if wasSpace and not isSpace:
                count += 1
            wasSpace = isSpace

        return count
