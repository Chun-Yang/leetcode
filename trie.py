class TrieNode():
    def __init__(self):
        self.isWord = False
        self.children = dict()

class Trie():
    def __init__(self):
        self.root = TrieNode()
        self.deletedWords = []

    def insert(self, word):
        node = self.root
        for char in word:
            if not (char in node.children):
                node.children[char] = TrieNode()
            node = node.children[char]
        node.isWord = True

    # here we assume the word exist in the trie
    # we also assume we do not delete a word that contain another word
    def delete(self, word):
        node = self.root
        branchNode = None
        branchChar = None
        # 1. has children itself, mark as false
        # 2. do not have children (leaf), last branch, remove the child

        for c in word:
            if len(node.children) > 1:
                branchNode = node
                branchChar = c
            node = node.children[c]

        if len(node.children) == 0:
            del branchNode.children[branchChar]
        else:
            node.isWord = False

        self.deletedWords.append(word)

    def print(self, node=None, word=''):
        node = node or self.root
        if len(node.children) == 0:
            print(word)
            return
        for c in node.children:
            self.print(node.children[c], word + c)

trie = Trie()
trie.insert('black')
trie.insert('blacken')
trie.insert('defence')
trie.insert('big')
trie.insert('dig')
print('=== Trie')
trie.print()
trie.delete('dig')
print('=== Trie')
trie.print()
trie.delete('black')
print('=== Trie')
trie.print()
