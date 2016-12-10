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
        p2w = {}
        for i in range(len(pattern)):
            if words[i] in w2p:
                if w2p[words[i]] != pattern[i]:
                    return False
            else:
                if pattern[i] in p2w:
                    return False
                p2w[pattern[i]] = words[i]
                w2p[words[i]] = pattern[i]

        return True
