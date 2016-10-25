class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        memo = [None] * (len(s) + 1)
        memo[len(s)] = ['']
        def sentences(i):
            if memo[i] != None:
                return memo[i]

            res = []
            for j in range(i + 1, len(s) + 1):
                if s[i:j] in wordDict:
                    for sentence in sentences(j):
                        res.append(s[i:j] + ' ' + sentence)

            memo[i] = res
            return res

        res = [sentence[:-1] for sentence in sentences(0)]
        return res


# assert set(Solution().wordBreak("a", ['a'])) == set(['a'])

# assert set(Solution().wordBreak("catsanddog", ["cat", "cats", "and", "sand", "dog"])) == set(["cats and dog", "cat sand dog"])

# assert Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]) == []

