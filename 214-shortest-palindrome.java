// FUTURE: use KMP
public class Solution {
  public String shortestPalindrome(String s) {
    // find the length of the longest palindrome prefix
    int l = s.length();
    char[] chars = s.toCharArray();
    int maxLength = 0;
    for (int end=l-1; end>=0; end--) {
      if (isPalindrome(chars, 0, end)) {
        maxLength = end + 1;
        break;
      }
    }

    // use the length to construct the whole string
    StringBuilder sb = new StringBuilder(s.substring(maxLength));
    sb.reverse();
    sb.append(s);

    return sb.toString();
  }
  private boolean isPalindrome(char[] chars, int start, int end) {
    while (start < end) {
      if (chars[start] != chars[end]) return false;
      start++;
      end--;
    }
    return true;
  }
}
