class Solution(object):
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        rows = [
                'qwertyuiop',
                'asdfghjkl',
                'zxcvbnm'
                ]
        charToRow = {}
        for i in range(len(rows)):
            for c in rows[i]:
                charToRow[c] = i

        res = []
        for word in words:
            row = charToRow[word[0].lower()]
            if all(charToRow[c.lower()] == row for c in word):
                res.append(word)

        return res
