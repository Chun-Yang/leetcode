import java.util.*;

public class Solution {
  public static void main (String[] args) {
    Solution s = new Solution();
    s.findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
  }
  public List<Integer> findSubstring(String s, String[] words) {
    // check for edge cases
    int l = s.length();
    int n = words.length;
    if (n == 0) return new ArrayList<Integer>();
    int wl = words[0].length();
    if (l < n * wl) return new ArrayList<Integer>();

    // create counter of words
    HashMap<String, Integer> counter = new HashMap<>();
    for (String word : words) counter.put(word, counter.getOrDefault(word, 0) + 1);

    // for each sliding windows
    List<Integer> starts = new ArrayList<Integer>();
    int maxI = Math.min(wl - 1, l - n * wl);
    for (int i=0; i<=maxI; i++) {
      // slide through the whole string
      HashMap<String, Integer> curCounter = new HashMap<>(counter);
      for (int start=i; start + wl <= l; start += wl) {
        // add to window
        String toAdd = s.substring(start, start + wl);
        curCounter.put(toAdd, curCounter.getOrDefault(toAdd, 0) - 1);
        if (curCounter.get(toAdd) == 0) curCounter.remove(toAdd);
        // remove from window
        // n = 1
        // wl = 2
        // 0 1 2 3 4 5
        // [ ]
        //   [ ]
        if (start >= n * wl) {
          String toRemove = s.substring(start - n * wl, start - n * wl + wl);
          curCounter.put(toRemove, curCounter.getOrDefault(toRemove, 0) + 1);
          if (curCounter.get(toRemove) == 0) curCounter.remove(toRemove);
        }
        if (curCounter.isEmpty()) starts.add(start);
      }
    }

    return starts;
  }
}
