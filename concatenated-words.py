class Solution(object):
    def findAllConcatenatedWordsInADict(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        s, ans = set(words), []
        def dfs(string):
            if string in s:
                return True
            for i in range(len(string)):
                if string[:i] in s and dfs(string[i:]):
                    return True
            return False
        for word in words:
            for i in range(1, len(word)):
                if word[:i] in s and dfs(word[i:]):
                    ans.append(word)
                    break
        return ans
