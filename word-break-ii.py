class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        memo = {len(s): ['']}
        def sentences(i):
            if i in memo:
                return memo[i]

            res = []
            for j in range(i + 1, len(s) + 1):
                if s[i:j] in wordDict:
                    for sentence in sentences(j):
                        res.append(s[i:j] + (sentence and ' ' + sentence))

            memo[i] = res
            return res

        return sentences(0)

# class Solution(object):
#     def wordBreak(self, s, wordDict):
#         memo = {len(s): ['']}
#         def sentences(i):
#             if i not in memo:
#                 strings = []
#                 for j in range(i+1, len(s)+1):
#                     if s[i:j] in wordDict:
#                         for tail in sentences(j):
#                             strings.append(s[i:j] + (tail and ' ' + tail))
#                 memo[i] = strings
#             return memo[i]
#         return sentences(0)

# assert set(Solution().wordBreak("a", ['a'])) == set(['a'])

# assert set(Solution().wordBreak("catsanddog", ["cat", "cats", "and", "sand", "dog"])) == set(["cats and dog", "cat sand dog"])

# assert Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]) == []

