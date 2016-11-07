class Solution(object):
    def palindromePairs(self, words):
        """
        :type words: List[str]
        :rtype: List[List[int]]
        """

        # find all prefix of a word that left with palindroms
        def findPrefixes(s):
            return [s[:i] for i in range(0, len(s) + 1) if s[i:] == s[i:][::-1]]

        prefixes = {}
        for i in range(len(words)):
            for prefix in findPrefixes(words[i]):
                if prefix in prefixes:
                    prefixes[prefix].append(i)
                else:
                    prefixes[prefix] = [i]

        pairs = set()
        wordsDict = { words[i]: i for i in range(len(words)) }
        wordsRev = [word[::-1] for word in words]
        for i in range(len(words)):
            for prefix in findPrefixes(wordsRev[i]):
                if prefix in wordsDict:
                    pairs.add((wordsDict[prefix], i))
            if wordsRev[i] in prefixes:
                for j in prefixes[wordsRev[i]]:
                    pairs.add((j, i))

        return [pair for pair in pairs if pair[0] != pair[1]]

# assert Solution().palindromePairs(["a","b","c","ab","ac","aa"])
# assert Solution().palindromePairs(["bat", "tab", "cat"]) == [[0, 1], [1, 0]]
