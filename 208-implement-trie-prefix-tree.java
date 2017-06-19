public class Trie {
  class Node {
    public boolean isWordEnd;
    public Node[] children;
    public Node() {
      children = new Node[26];
      isWordEnd = false;
    }
  }

  Node trie;

  /** Initialize your data structure here. */
  public Trie() {
    trie = new Node();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    Node node = trie;
    for (int i=0; i<word.length(); i++) {
      char c = word.charAt(i);
      if (node.children[c-'a'] == null) node.children[c-'a'] = new Node();
      node = node.children[c-'a'];
    }
    node.isWordEnd = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    Node node = trie;
    for (int i=0; i<word.length(); i++) {
      char c = word.charAt(i);
      if (node.children[c-'a'] == null) return false;
      node = node.children[c-'a'];
    }
    return node.isWordEnd;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    Node node = trie;
    for (int i=0; i<prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (node.children[c-'a'] == null) return false;
      node = node.children[c-'a'];
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
