public class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> words = new HashSet<>(wordList);
    List<String> curWords = Arrays.asList(beginWord);
    int length = 2;
    // NOTE: we can use queue and length to replace two lists
    while (!curWords.isEmpty()) {
      List<String> nextWords = new ArrayList<>();
      for (String word: curWords) {
        if (addWords(word, endWord, nextWords, words )) return length;
      }
      curWords = nextWords;
      length++;
    }
    return 0;
  }
  private boolean addWords(String word, String endWord, List<String> nextWords, Set<String> words) {
    for (int i=0; i < word.length(); i++) {
      char[] chars = word.toCharArray();
      for (char c='a'; c <= 'z'; c++) {
        chars[i] = c;
        String neighbor = new String(chars);
        if (words.contains(neighbor)) {
          if (neighbor.equals(endWord)) return true;
          words.remove(neighbor);
          nextWords.add(neighbor);
        }
      }
    }
    return false;
  }
}
