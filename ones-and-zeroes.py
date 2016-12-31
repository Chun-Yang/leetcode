import collections

class Solution(object):
    def findMaxForm(self, strs, m, n):
        """
        :type strs: List[str]
        :type m: int
        :type n: int
        :rtype: int
        """
        maxes = [[0 for j in range(n + 1)] for i in range(m + 1)]
        for s in strs:
            counter = collections.Counter(s)
            zeros, ones = counter['0'], counter['1']
            for i in reversed(range(m + 1)):
                for j in reversed(range(n + 1)):
                    previ = i - zeros
                    prevj = j - ones
                    if previ >= 0 and prevj >= 0:
                        maxes[i][j] = max(maxes[i][j], 1 + maxes[previ][prevj])

        return maxes[m][n]

# Solution().findMaxForm(["10","0001","111001","1","0"], 5, 3)
