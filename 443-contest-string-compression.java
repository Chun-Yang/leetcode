// Given an array of characters, compress it in-place.

// The length after compression must always be smaller than or equal to the original array.

// Every element of the array should be a character (not int) of length 1.

// After you are done modifying the input array in-place, return the new length of the array.

// Example 1:
// Input:
// ["a","a","b","b","c","c","c"]

// Output:
// Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

// Explanation:
// "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
// Example 2:
// Input:
// ["a"]

// Output:
// Return 1, and the first 1 characters of the input array should be: ["a"]

// Explanation:
// Nothing is replaced.
// Example 3:
// Input:
// ["a","b","b","b","b","b","b","b","b","b","b","b","b"]

// Output:
// Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

// Explanation:
// Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
// Notice each digit has it's own entry in the array.
// Note:
// All characters have an ASCII value in [35, 126].
// 1 <= len(chars) <= 1000.

// solution1: two pointer
class Solution {
  public int compress(char[] chars) {
    int n = chars.length;
    if (n == 0) {
      return 0;
    }

    int length = 1;
    int preCount = 1;
    char preChar = chars[0];
    for (int i=1; i<=n; i++) {
      if (i == n || preChar != chars[i]) {
        if (preCount > 1) {
          for (char digit : Integer.toString(preCount).toCharArray()) {
            chars[length++] = digit;
          }
        }
        if (i != n) {
          chars[length++] = chars[i];
          preChar = chars[i];
          preCount = 1;
        }
      } else {
        preCount++;
      }
    }
    return length;
  }
}
