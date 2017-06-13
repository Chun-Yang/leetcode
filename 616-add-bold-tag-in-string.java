public class Solution {
  // merge interval

  // boolean array
  public String addBoldTag(String s, String[] dict) {
    if (s.length() == 0) return "";

    // 1. label all bold (the last one and first one are not bold)
    HashSet<String> words = new HashSet<>(dict);
    boolean[] bold = new boolean[s.length() + 1];
    // [start, end]
    for (int start=0; start<s.length(); start++) {
      if (bold[s.length() - 1]) break;
      for (int end=s.length()-1; end>=start; end--) {
        if (bold[end]) break;
        if (words.contains(s.substring(start, end+1))) {
          for (int i=end; i>=start; i--) {
            if (bold[i]) break;
            bold[i] = true;
          }
        }
      }
    }

    // 2. use bold to create the new string
    StringBuilder sb = new StringBuilder();
    if (bold[0]) sb.append("<b>");
    for (int i=0; i<s.length(); i++) {
      sb.append(s.charAt(i));
      if (bold[i] && !bold[i+1]) {
        sb.append("</b>");
      }
      else if (!bold[i] && bold[i+1]) {
        sb.append("<b>");
      }
    }
    return sb.toString();
  }
}
