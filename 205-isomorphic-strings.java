public class Solution {
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) return false;
    int l = s.length();

    HashMap<Character, Integer> sMap = new HashMap<>();
    HashMap<Character, Integer> tMap = new HashMap<>();
    for (int i=0; i<l; i++) {
      char sChar = s.charAt(i);
      char tChar = t.charAt(i);
      int sIndex = sMap.getOrDefault(sChar, i);
      int tIndex = tMap.getOrDefault(tChar, i);
      if (sIndex != tIndex) return false;
      sMap.put(sChar, sIndex);
      tMap.put(tChar, tIndex);
    }

    return true;
  }
}
