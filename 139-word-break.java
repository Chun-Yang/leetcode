public class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    HashSet<String> words = new HashSet<String>(wordDict);
    int length = s.length();
    boolean[] valid = new boolean[length + 1];
    valid[0] = true;
    for (int end=1; end<=length; end++) {
      for (int start=0; start < end; start++) {
        if (valid[start] && words.contains(s.substring(start, end))) {
          valid[end] = true;
          break;
        }
      }
    }
    return valid[length];
  }
}
