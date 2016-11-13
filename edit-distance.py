class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        if len(word1) > len(word2):
            wordLong, wordShort = word1, word2
        else:
            wordLong, wordShort = word2, word1

        lenShort = len(wordShort)
        lenLong = len(wordLong)

        dp = [[None] * (lenLong + 1) for i in range(lenShort + 1)]
        for i in range(lenShort + 1):
            dp[i][lenLong] = lenShort - i
        for j in range(lenLong + 1):
            dp[lenShort][j] = lenLong - j
        for i in reversed(range(lenShort)):
            for j in reversed(range(lenLong)):
                if wordShort[i] == wordLong[j]:
                    dp[i][j] = 1 + min(dp[i+1][j], dp[i][j+1], dp[i+1][j+1] - 1)
                else:
                    dp[i][j] = 1 + min(dp[i+1][j], dp[i][j+1], dp[i+1][j+1])

        return dp[0][0]
