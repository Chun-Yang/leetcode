public class Solution {
  public int calculate(String s) {
    int result = 0;
    int sign = 1;
    Deque<Integer> signs = new LinkedList<Integer>();
    signs.push(1);

    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      switch (chars[i]) {
        case ' ':
          break;
        case '+':
          sign = 1;
          break;
        case '-':
          sign = -1;
          break;
        case '(':
          signs.push(signs.peek() * sign);
          sign = 1;
          break;
        case ')':
          signs.pop();
          sign = 1; // NOTE: this is not necessary since we will encounter a sign before a number
          break;
        default:
          int start = i;
          int num = 0;
          while (i < s.length() && chars[i] >= '0' && chars[i] <= '9') {
            num = num * 10 + (chars[i] - '0');
            i++;
          }
          i--;
          result += sign * signs.peek() * num;
          break;
      }
    }
    return result;
  }
}
