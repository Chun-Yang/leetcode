class Solution(object):
    def maxEnvelopes(self, envelopes):
        if len(envelopes) == 0:
            return 0

        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        envelopes = sorted(envelopes, reverse=True)
        memo = [None] * len(envelopes)
        memo[len(envelopes) - 1] = 1

        def maxEnvelopesAt(i):
            if memo[i]:
                return memo[i]

            memo[i] = 1

            for j in range(i + 1, len(envelopes)):
                if envelopes[i][0] > envelopes[j][0] and envelopes[i][1] > envelopes[j][1]:
                    memo[i] = max(memo[i], maxEnvelopesAt(j) + 1)

            return memo[i]


        res = max(maxEnvelopesAt(i) for i in range(len(envelopes)))
        return res

assert Solution().maxEnvelopes([[5,4],[6,4],[6,7],[2,3]]) ==  3
assert Solution().maxEnvelopes([[1,3],[3,5],[6,7],[6,8],[8,4],[9,5]]) == 3
