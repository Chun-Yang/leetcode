public class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] alphabet = new int[256];
    for (int i=0; i<s.length(); i++) {
      alphabet[s.charAt(i)]++;
      alphabet[t.charAt(i)]--;
    }
    for (char c = 'a'; c <= 'z'; c++) {
      if (alphabet[c] != 0) return false;
    }
    return true;
  }
}
