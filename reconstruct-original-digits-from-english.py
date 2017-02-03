from collections import Counter

class Solution(object):
    def originalDigits(self, s):
        """
        :type s: str
        :rtype: str
        """
        charCounts = Counter(s)
        numCounts = [0] * 10

        numCounts[0] = charCounts['z']
        numCounts[2] = charCounts['w']
        numCounts[6] = charCounts['x']
        numCounts[8] = charCounts['g']

        numCounts[7] = charCounts['s'] - numCounts[6]
        numCounts[5] = charCounts['v'] - numCounts[7]
        numCounts[4] = charCounts['f'] - numCounts[5]

        numCounts[3] = charCounts['r'] - numCounts[0] - numCounts[4]

        numCounts[9] = charCounts['i'] - numCounts[5] - numCounts[6] - numCounts[8]
        numCounts[1] = charCounts['o'] - numCounts[0] - numCounts[2] - numCounts[4]

        return ''.join(str(i) * numCounts[i] for i in range(10))
