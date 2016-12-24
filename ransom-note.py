from collections import Counter

class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """

        rCounter = Counter(ransomNote)
        mCounter = Counter(magazine)

        return all(c in mCounter and mCounter[c] >= rCounter[c] for c in rCounter.keys())
