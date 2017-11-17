// Given an encoded string, return it's decoded string.

// The encoding rule is: k[encoded_string], where the encoded_string inside the
// square brackets is being repeated exactly k times. Note that k is guaranteed
// to be a positive integer.

// You may assume that the input string is always valid; No extra white spaces,
// square brackets are well-formed, etc.

// Furthermore, you may assume that the original data does not contain any
// digits and that digits are only for those repeat numbers, k. For example,
// there won't be input like 3a or 2[4].

// Examples:

// s = "3[a]2[bc]", return "aaabcbc".
// s = "3[a2[c]]", return "accaccacc".
// s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

// solution1: useing two stack to track current string
import java.util.*;

// class Solution {
//   public String decodeString(String s) {
//     Stack<String> tokens = new Stack<>();
//     Stack<Integer> repeats = new Stack<>();
//     StringBuilder token = new StringBuilder();
//     int repeat = 0;
//     for (char c : s.toCharArray()) {
//       if (c == '[')  {
//         tokens.push(token.toString());
//         repeats.push(repeat);
//         token = new StringBuilder();
//         repeat = 0;
//       } else if (c == ']') {
//         String currentToken = token.toString();
//         token = new StringBuilder(tokens.pop());
//         int previousRepeat = repeats.pop();
//         for (int i=0; i<previousRepeat; i++) {
//           token.append(currentToken);
//         }
//       } else if (c >= '0' && c <= '9') {
//         repeat = repeat * 10 + (c - '0');
//       } else {
//         token.append(c);
//       }
//     }
//     return token.toString();
//   }
// }

// refactor, NOTE: this is not very easy to reason about?
class Solution {
  public String decodeString(String s) {
    Stack<StringBuilder> tokens = new Stack<>();
    tokens.push(new StringBuilder());
    Stack<Integer> repeats = new Stack<>();
    repeats.push(0);

    for (char c : s.toCharArray()) {
      if (c == '[')  {
        tokens.push(new StringBuilder());
        repeats.push(0);
      } else if (c == ']') {
        String currentToken = tokens.pop().toString();
        repeats.pop();
        int previousRepeat = repeats.pop();
        for (int i=0; i<previousRepeat; i++) {
          tokens.peek().append(currentToken);
        }
        repeats.push(0);
      } else if (c >= '0' && c <= '9') {
        repeats.push(repeats.pop() * 10 + (c - '0'));
      } else {
        tokens.peek().append(c);
      }
    }

    return tokens.pop().toString();
  }
}
