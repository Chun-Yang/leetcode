import java.util.List;
import java.util.ArrayList;

public class Solution {
  public List<String> restoreIpAddresses(String s) {
    List<String> ips = new ArrayList<>();
    dfs(s, s.length(), 0, 4, new ArrayList<>(), ips);
    return ips;
  }

  private void dfs(String s, int length, int start, int segmentsLeft, List<String> ip, List<String> ips) {
    if (segmentsLeft == 0) {
      ips.add(String.join(".", ip));
      return;
    }
    int nextSegmentsLeft = segmentsLeft - 1;
    int minLength = Math.max(1, length - nextSegmentsLeft * 3);
    int maxLength = Math.min(3, length - nextSegmentsLeft * 1);
    for (int l=minLength; l<=maxLength; l++) {
      if (isValidSegment(s.substring(start, start+l))) {
        ip.add(s.substring(start, start+l));
        dfs(s, length - l, start + l, nextSegmentsLeft, ip, ips);
        ip.remove(3 - nextSegmentsLeft);
      }
    }
  }

  private boolean isValidSegment(String s) {
    if (s.length() == 1) {
      return true;
    } else if (s.length() == 2) {
      return s.charAt(0) != '0';
    } else {
      return s.charAt(0) == '1' || (s.charAt(0) == '2'
          && (s.charAt(1) <= '4' || (s.charAt(1) == '5'
              && (s.charAt(2) <= '5')))
          );
    }
  }
}
