import java.util.*;

public class Solution {
  class TrieNode {
    public String word;
    public TrieNode[] children;
    public TrieNode() {
      children = new TrieNode[26];
    }
  }

  private TrieNode createTrieFromWords(String[] words) {
    TrieNode trie = new TrieNode();

    for (String word : words) {
      TrieNode node = trie;
      for (int i=0; i<word.length(); i++) {
        int c = word.charAt(i);
        if (node.children[c-'a'] == null) node.children[c-'a'] = new TrieNode();
        node = node.children[c-'a'];
      }
      node.word = word;
    }

    return trie;
  }

  int m;
  int n;
  char[][] board;
  boolean[][] visited;
  List<String> found;
  TrieNode trie;

  public List<String> findWords(char[][] board, String[] words) {
    m = board.length;
    if (m==0) return new ArrayList<>();
    n = board[0].length;
    if (n==0) return new ArrayList<>();

    this.board = board;
    visited = new boolean[m][n];
    found = new ArrayList<>();
    trie = createTrieFromWords(words);

    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        dfs(i, j, trie);
      }
    }

    return found;
  }

  private void dfs(int i, int j, TrieNode node) {
    if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;

    char c = board[i][j];
    TrieNode nextNode = node.children[c-'a'];
    if (nextNode == null) return;
    if (nextNode.word != null) {
      found.add(nextNode.word);
      nextNode.word = null;
    }

    visited[i][j] = true;
    dfs(i-1, j, nextNode);
    dfs(i+1, j, nextNode);
    dfs(i, j-1, nextNode);
    dfs(i, j+1, nextNode);
    visited[i][j] = false;
  }
}
