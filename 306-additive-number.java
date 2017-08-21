// Additive number is a string whose digits can form additive sequence.

// A valid additive sequence should contain at least three numbers. Except for the
// first two numbers, each subsequent number in the sequence must be the sum of
// the preceding two.

// For example: "112358" is an additive number because the digits can form an
// additive sequence: 1, 1, 2, 3, 5, 8.

// 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8 "199100199" is also an additive
// number, the additive sequence is: 1, 99, 100, 199. 1 + 99 = 100, 99 + 100 = 199
// Note: Numbers in the additive sequence cannot have leading zeros, so sequence
// 1, 2, 03 or 1, 02, 3 is invalid.

// Given a string containing only digits '0'-'9', write a function to determine if
// it's an additive number.

// Follow up: How would you handle overflow for very large input integers?

class Solution {
  public boolean isAdditiveNumber(String num) {
    return dfs("0", "0", 0, 0, num.length(), num);
  }
  private boolean dfs (String first, String second, int index, int start, int length, String num) {
    if (start == length) return index >= 3;
    if (index < 2) {
      if (num.charAt(start) == '0') return dfs(second, "0", index+1, start+1, length, num);
      for (int end=start+1; end<=length; end++) {
        if (dfs(second, num.substring(start, end), index+1, end, length, num)) return true;
      }
      return false;
    } else {
      String third = add(first, second);
      int end = start + third.length();
      return end <= length
        && third.equals(num.substring(start, end))
        && dfs(second, third, index+1, end, length, num);
    }
  }

  private String add (String a, String b) {
    StringBuilder sb = new StringBuilder();
    int al = a.length();
    int bl = b.length();
    int carry = 0;
    for (int i=0; i<Math.max(al, bl); i++) {
      int aDigit = al > i ? a.charAt(al - i - 1) - '0' : 0;
      int bDigit = bl > i ? b.charAt(bl - i - 1) - '0' : 0;
      int sum = aDigit + bDigit + carry;
      sb.append(Integer.toString(sum % 10));
      carry = sum >= 10 ? 1 : 0;
    }
    if (carry == 1) sb.append('1');
    return sb.reverse().toString();
  }
}
