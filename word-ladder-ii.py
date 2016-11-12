from collections import deque
from collections import defaultdict

class Solution(object):
    def findLadders(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: Set[str]
        :rtype: int
        """

        wordList -= set([beginWord, endWord])

        # return a list of arrays that ends with endWord
        beginWords = set([beginWord])
        dependencies = defaultdict(lambda: set())

        def traceLadders():
            ladders = deque([[endWord]])

            while True:
                # found the beginWord
                if not dependencies[ladders[0][0]]:
                    break
                for i in range(len(ladders)):
                    ladder = ladders.pop()
                    for word in dependencies[ladder[0]]:
                        ladders.appendleft([word] + ladder)

            res = [list(ladder) for ladder in ladders]
            return res

        # check if find endWord, build dependencies, reduce wordList
        while True:
            if not beginWords:
                return []

            usedWords = set()
            found = False
            for i in range(len(beginWords)):
                word = beginWords.pop()
                for j in range(len(word)):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        if c == word[j]:
                            continue
                        adjacentWord = word[:j] + c + word[j+1:]
                        if adjacentWord == endWord:
                            found = True
                            dependencies[adjacentWord].add(word)
                        elif adjacentWord in wordList:
                            usedWords.add(adjacentWord)
                            dependencies[adjacentWord].add(word)

            if found:
                return traceLadders()

            beginWords = usedWords
            wordList -= usedWords

        return []


# assert Solution().findLadders("a", "c", set(["b"])) == [['a', 'c']]
# assert Solution().findLadders("hit", "cog", set(["hot","dot","dog","lot","log"])) == [ ["hit","hot","lot","log","cog"], ["hit","hot","dot","dog","cog"] ]
# assert Solution().findLadders("hot", "dog", set(["hot","dog","dot"])) == [["hot", "dot", "dog"]]
