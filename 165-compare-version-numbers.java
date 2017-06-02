public class Solution {
  public int compareVersion(String version1, String version2) {
    String[] vs1 = version1.split("\\.");
    String[] vs2 = version2.split("\\.");
    int length = Math.max(vs1.length, vs2.length);
    for (int i=0; i<length; i++) {
      int v1 = i >= vs1.length ? 0 : Integer.parseInt(vs1[i]);
      int v2 = i >= vs2.length ? 0 : Integer.parseInt(vs2[i]);
      if (v1 > v2) return 1;
      if (v2 > v1) return -1;
    }
    return 0;
  }
}
