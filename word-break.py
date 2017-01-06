class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        words = set(wordDict)
        sizeS = len(s)
        ends = [True] + [False] * sizeS
        for i in range(1, sizeS + 1):
            for j in reversed(range(i)):
                if ends[j] and s[j:i] in words:
                    ends[i] = True
                    break

        return ends[sizeS]


# assert Solution().wordBreak("bb", ["a","b","bbb","bbbb"]) == False
