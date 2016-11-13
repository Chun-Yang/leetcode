class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        len1 = len(s1)
        len2 = len(s2)
        len3 = len(s3)

        dp = [[None] * (len2 + 1) for i in range(len1 + 1)]

        for i in range(len1 + 1):
            dp[i][len2] = s1[i:] == s3[i+len2:]

        for j in range(len2 + 1):
            dp[len1][j] = s2[j:] == s3[j+len1:]

        for i in reversed(range(len1)):
            for j in reversed(range(len2)):
                dp[i][j] = (s1[i] == s3[i+j] and dp[i+1][j]) or (s2[j] == s3[i+j] and dp[i][j+1])

        return dp[0][0]

# assert Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac") == True
# assert Solution().isInterleave("aabcc", "dbbca", "aadbbbaccc") == False
# assert Solution().isInterleave("a", "", "a") == True
