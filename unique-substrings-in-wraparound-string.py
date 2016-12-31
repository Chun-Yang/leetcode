class Solution(object):
    def findSubstringInWraproundString(self, p):
        """
        :type p: str
        :rtype: int
        """
        orda = ord('a')
        alphabeta = 'abcdefghijklmnopqrstuvwxyz'
        nextDict = {alphabeta[i]: alphabeta[(i+1) % 26] for i in range(26)}

        counts = [0] * 26
        padded = p + '#'
        start = 0
        for i in range(len(p)):
            if nextDict[padded[i]] != padded[i+1]:
                index = ord(p[start]) - orda
                counts[index] = max(counts[index], i - start + 1)
                start = i + 1

        ans = sum(max(counts[j] - ((26 + i - j) % 26) for j in range(26)) for i in range(26))
        return ans

