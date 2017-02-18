class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if not strs:
            return ''

        sizes = [len(s) for s in strs]
        minSize = min(sizes)
        for i in range(minSize):
            c = strs[0][i]
            for s in strs:
                if s[i] != c:
                    return s[:i]

        return strs[0][:minSize]
