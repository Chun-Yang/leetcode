public class WordDictionary {
  class Node {
    public boolean isWordEnd;
    public Node[] children;
    public Node() {
      isWordEnd = false;
      children = new Node[26];
    }
  }

  private Node trie;
  /** Initialize your data structure here. */
  public WordDictionary() {
    trie = new Node();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    Node node = trie;
    for (int i=0; i<word.length(); i++) {
      char c = word.charAt(i);
      if (node.children[c-'a'] == null) node.children[c-'a'] = new Node();
      node = node.children[c-'a'];
    }
    node.isWordEnd = true;
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  public boolean search(String word) {
    return dfs(0, word, trie);
  }
  private boolean dfs(int i, String word, Node node) {
    if (node == null) return false;
    if (i == word.length()) return node.isWordEnd;

    char c = word.charAt(i);
    if (c == '.') {
      for (char x='a'; x<='z'; x++) {
        if (dfs(i+1, word, node.children[x-'a'])) return true;
      }
      return false;
    } else {
      return dfs(i+1, word, node.children[c-'a']);
    }
  }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
