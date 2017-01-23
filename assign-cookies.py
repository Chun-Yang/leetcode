class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        sizeG, sizeS = len(g), len(s)
        if sizeG == 0 or sizeS == 0:
            return 0

        s, g = sorted(s), sorted(g)
        i, j, count = 0, 0, 0
        while i < sizeG and j < sizeS:
            if g[i] <= s[j]:
                count += 1
                i += 1
            j += 1

        return count
