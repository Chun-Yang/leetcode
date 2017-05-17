public class Solution {
  public List<String> wordBreak(String s, List<String> wordDict) {
    int length = s.length();
    HashSet<String> words = new HashSet<String>(wordDict);

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
    if (!valid[length]) return new ArrayList<>();

    List<List<String>> breaks = new ArrayList<>();
    breaks.add(new ArrayList<String>(Arrays.asList("")));

    for (int end=1; end<=length; end++) {
      List<String> breakForIndex = new ArrayList<>();
      for (int start=0; start<end; start++) {
        if (words.contains(s.substring(start, end))) {
          for (String b : breaks.get(start)) {
            if (start == 0) {
              breakForIndex.add(s.substring(start, end));
            } else {
              breakForIndex.add(b + " " + s.substring(start, end));
            }
          }
        }
      }
      breaks.add(breakForIndex);
    }

    return breaks.get(length);
  }
}
