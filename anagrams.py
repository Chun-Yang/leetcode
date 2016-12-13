class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        def calcHash(s):
            chars = [0] * 26
            for c in s:
                chars[ord(c) - ord('a')] += 1
            return tuple(chars)

        groups = {}
        for s in strs:
            hashTuple = calcHash(s)
            if hashTuple in groups:
                groups[hashTuple].append(s)
            else:
                groups[hashTuple] = [s]

        return list(groups.values())
