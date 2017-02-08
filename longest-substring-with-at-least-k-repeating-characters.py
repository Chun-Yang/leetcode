from heapq import heappush, heappop

class Solution(object):
    def longestSubstring(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        longestLength = 0
        starts = []
        counter = {c:0 for c in 'abcedfghijklmnopqrstuvwxyz'}

        for i, c in enumerate(s):
            counter[c] += 1

            heappush(starts, (-i, c))

            while starts and counter[starts[0][1]] >= k:
                heappop(starts)

            if starts:
                curStart = - starts[0][0]
                curLength = i - curStart
                longestLength = max(longestLength, curLength)
            else:
                longestLength = i + 1

        return longestLength

assert Solution().longestSubstring("ababacb", 3) == 0
