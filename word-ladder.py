from collections import deque

class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: Set[str]
        :rtype: int
        """
        queue = deque()
        queue.appendleft(beginWord)
        length = 1

        while True:
            # can not find it
            if not queue:
                return 0

            for i in range(len(queue)):
                word = queue.pop()
                if word == endWord:
                    return length
                for j in range(len(word)):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        adjacentWord = word[0:j] + c + word[j+1:]
                        if adjacentWord == endWord:
                            return length + 1
                        if adjacentWord in wordList:
                            wordList.remove(adjacentWord)
                            queue.appendleft(adjacentWord)

            length += 1


# assert Solution().ladderLength("a", "c", ["b"]) == 2
# assert Solution().ladderLength("hit", "cog", ["hot","dot","dog","lot","log"]) == 5
