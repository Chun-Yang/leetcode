import java.util.*;

public class Solution {
  public List<String> removeInvalidParentheses(String s) {
    List<String> validStrings = new ArrayList<>();
    remove(s, validStrings, 0, 0, new char[]{ '(', ')' });
    return validStrings;
  }
  private void remove (String s, List<String> validStrings, int start, int lastRemovedAt, char[] pair) {
    int open = 0;
    for (int i=start; i<s.length(); i++) {
      if (s.charAt(i) == pair[0]) open++;
      else if (s.charAt(i) == pair[1]) open--;
      if (open < 0) {
        // NOTE: when j is i, this is definitly like this )) which means
        // this is not the first consecutive one
        // NOTE 1 is wrong since )
        // NOTE: their are only two posibilitis:
        // 1. lastRemovedAt
        // 2. currentPosition, remember to set lastRemovedAt to the one before currentPosition
        // NOTE 2 is wrong since ()()())
        for (int j=lastRemovedAt; j<=i; j++) {
          if (s.charAt(j) == pair[1] && (j==lastRemovedAt || s.charAt(j-1)!=pair[1])) {
            remove(s.substring(0, j) + s.substring(j+1), validStrings, i, j, pair);
          }
        }
        return;
      }
    }

    String reversed = new StringBuilder(s).reverse().toString();
    if (pair[0] == '(') {
      remove(reversed, validStrings, 0, 0, new char[]{ ')', '(' });
    } else {
      validStrings.add(reversed);
    }
  }
}
