class WordDictionary(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.trie = {}

    def addWord(self, word):
        """
        Adds a word into the data structure.
        :type word: str
        :rtype: void
        """
        node = self.trie
        for c in word:
            if c not in node:
                node[c] = {}
            node = node[c]
        node['isWord'] = True

    def search(self, word):
        """
        Returns if the word is in the data structure. A word could
        contain the dot character '.' to represent any one letter.
        :type word: str
        :rtype: bool
        """
        def find(word, node):
            if not word:
                return 'isWord' in node
            c, word = word[0], word[1:]
            if c != '.':
                return (c in node) and find(word, node[c])
            for c in node:
                if c != 'isWord' and find(word, node[c]):
                    return True
            return False

        return find(word, self.trie)


# Your WordDictionary object will be instantiated and called as such:
# wordDictionary = WordDictionary()
# wordDictionary.addWord("word")
# wordDictionary.search("pattern")
