class Solution(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        counts = collections.Counter(s)
        for c in t:
            if c not in counts or counts[c] == 0:
                return c
            else:
                counts[c] -= 1
