// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".

// Note:
// If there is no such window in S that covers all characters in T, return the empty string "".

// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.


// solution1: sliding window / pointers
// the faster pointer is the iterator(also right boundary)
// the slow pointer is the left boundary
// constrain: the sliding window contains all chars in t
// - a list to save count of letters (26 if lowercase)
// 1. we add new char in
//    - check if we have valid substring
//    - if not we add it in
//    - else we need to remove as many chars as possible and
//      maintains the constrain
//      NOTE: we can break the constrain since we know the shortest one
//      starting with the current starting point is already captured
//    - then we check if length is smaller

import java.util.HashMap;
import java.util.Arrays;

class Solution {
  // public String minWindow(String s, String t) {
  //   if (s.length() == 0 || t.length() == 0) return "";

  //   int[] counter = new int[128];
  //   // the targets will determin if we have a match or not,
  //   // so we do not need to keep track of chars that is over the limit.
  //   int targets = t.length();
  //   int ml = 0, mr = 0, l = 0, r = 1;

  //   // initlaize counter
  //   for (int i=0; i<t.length(); i++) counter[t.charAt(i)]++;

  //   // move right
  //   while (r <= s.length()) {
  //     char charRight = s.charAt(r-1);
  //     if (counter[charRight] > 0) {
  //       targets--;
  //     }

  //     // update counter, if char is not present, it would be negative
  //     counter[charRight]--;

  //     // match found, move left
  //     while (targets == 0) {
  //       // move left
  //       char charLeft = s.charAt(l);
  //       counter[charLeft]++;
  //       if (counter[charLeft] > 0) {
  //         // update ml and mr
  //         if (mr == 0 || mr - ml > r - l) {
  //           mr = r;
  //           ml = l;
  //         }
  //         targets++;
  //       }
  //       l++;
  //     }
  //     r++;
  //   }

  //   return s.substring(ml, mr);
  // }
  public String minWindow(String s, String t) {
    HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
    for (int i=0; i<t.length(); i++) {
      chars.put(t.charAt(i), chars.getOrDefault(t.charAt(i), 0) + 1);
    }

    HashMap<Character, Integer> missing = new HashMap<Character, Integer>(chars);
    HashMap<Character, Integer> extra = new HashMap<Character, Integer>();

    int lMin = 0, rMin = 0, l = 0, r = 1;
    while (r <= s.length()) {
      char c = s.charAt(r - 1);
      if (chars.containsKey(c)) {
        // update missing and extra
        if (missing.containsKey(c)) {
          missing.put(c, missing.get(c) - 1);
          if (missing.get(c) == 0) {
            missing.remove(c);
            // check empty
            if (missing.isEmpty()) {
              while (l < r) {
                char cLeft = s.charAt(l);
                if (chars.containsKey(cLeft)) {
                  if (extra.containsKey(cLeft)) {
                    extra.put(cLeft, extra.get(cLeft) - 1);
                    if (extra.get(cLeft) == 0) {
                      extra.remove(cLeft);
                    }
                  } else {
                    // set lMin and rMin
                    if (rMin == 0 || rMin - lMin > r - l) {
                      rMin = r;
                      lMin = l;
                    }
                    // update missing, remove the current one from window
                    l++;
                    missing.put(cLeft, 1);
                    break;
                  }
                }
                l++;
              }
            }
          }
        } else {
          extra.put(c, extra.getOrDefault(c, 0) + 1);
        }
      }

      r++;
    }

    return s.substring(lMin, rMin);
  }
  public static void main (String[] args) {
    Solution s = new Solution();
    assert s.minWindow("abc", "").equals("");
    assert s.minWindow("", "abc").equals("");
    assert s.minWindow("abc", "a").equals("a");
    assert s.minWindow("abc", "ab").equals("ab");
    assert s.minWindow("abc", "bc").equals("bc");
    assert s.minWindow("abc", "abc").equals("abc");
    assert s.minWindow("abcdeflzcfg", "fc").equals("cf");
    assert s.minWindow("", "fc").equals("");
    // NOTE: the problem is we should keep track of negative count too
    assert s.minWindow("bba", "ab").equals("ba");
  }
}
