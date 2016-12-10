class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """

        words = str.split(' ')
        if len(words) != len(pattern):
            return False

        w2p = {}
        existingPatterns = set()
        for i in range(len(pattern)):
            w, p = words[i], pattern[i]
            if w in w2p:
                if w2p[w] != p:
                    return False
            else:
                if p in existingPatterns:
                    return False
                existingPatterns.add(p)
                w2p[w] = p

        return True
