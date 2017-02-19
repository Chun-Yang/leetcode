from collections import Counter

class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        if not words:
            return []

        sSize = len(s)
        wSize = len(words[0])
        wsSize = wSize * len(words)
        wsCounter = Counter(words)
        indexes = []
        for i in range(wSize):
            if sSize < wsSize + i:
                break
            counter = dict(wsCounter)
            for j in range(sSize - wSize - i, -1, -wSize):
                addWord = s[j:j+wSize]
                if addWord in wsCounter:
                    if addWord not in counter:
                        counter[addWord] = -1
                    elif counter[addWord] == 1:
                        del counter[addWord]
                    else:
                        counter[addWord] -= 1

                removeWord = s[j+wsSize:j+wsSize+wSize]
                if removeWord in wsCounter:
                    if removeWord not in counter:
                        counter[removeWord] = 1
                    elif counter[removeWord] == -1:
                        del counter[removeWord]
                    else:
                        counter[removeWord] -= 1

                if not counter:
                    indexes.append(j)

        return indexes


# assert Solution().findSubstring("barfoothefoobarman", ["foo", "bar"]) == [0, 9]
