import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
  public String simplifyPath(String path) {
    String[] segments = path.split("/");
    LinkedList<String> stack = new LinkedList<String>();
    for (String segment: segments) {
      if (segment.equals(".") || segment.equals("")) {
        continue;
      } else if (segment.equals("..")) {
        if (!stack.isEmpty()) {
          stack.removeLast();
        }
      } else {
        stack.add(segment);
      }
    }

    if (stack.isEmpty()) return "/";

    StringBuilder s = new StringBuilder();
    for (String segment : stack) s.append("/" + segment);
    return s.toString();
  }
  public static void main (String[] args) {
    Solution s = new Solution();
    assert s.simplifyPath("/").equals("/");
    assert s.simplifyPath("/a/").equals("/a");
    assert s.simplifyPath("/a/../").equals("/");
    assert s.simplifyPath("/a/./").equals("/a");
  }
}
