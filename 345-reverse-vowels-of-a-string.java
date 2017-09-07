// Write a function that takes a string as input and reverse only the vowels of
// a string.

// Example 1:
// Given s = "hello", return "holle".

// Example 2:
// Given s = "leetcode", return "leotcede".

import java.util.*;
class Solution {
  public String reverseVowels(String s) {
    char[] chars = s.toCharArray();
    HashSet<Character> vowels = new HashSet<>(
        Arrays.asList(new Character[]{ 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' })
        );

    int i=0;
    int j=s.length() - 1;
    while (i < j) {
      if (!vowels.contains(chars[i])) i++;
      else if(!vowels.contains(chars[j])) j--;
      else {
        chars[i] = (char) (chars[i] ^ chars[j]);
        chars[j] = (char) (chars[i] ^ chars[j]);
        chars[i] = (char) (chars[i] ^ chars[j]);
        i++;
        j--;
      }
    }

    return new String(chars);
  }
}
