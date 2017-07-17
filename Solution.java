// Given a string that contains only digits 0-9 and a target value, return all
// possibilities to add binary operators (not unary) +, -, or * between the digits
// so they evaluate to the target value.

// Examples:
// "123", 6 -> ["1+2+3", "1*2*3"]
// "232", 8 -> ["2*3+2", "2+3*2"]
// "105", 5 -> ["1*0+5","10-5"]
// "00", 0 -> ["0+0", "0-0", "0*0"]
// "3456237490", 9191 -> []

import java.util.*;

public class Solution {
  String num;
  int length;
  int target;
  Deque<String> tokens;
  List<String> combos;

  public static void main (String[] args) {
    Solution s = new Solution();
    // System.out.println(s.addOperators("232", 8));
    // System.out.println(s.addOperators("105", 5));
  }

  public List<String> addOperators(String num, int target) {
    this.num = num;
    this.length = num.length();
    this.target = target;
    tokens = new LinkedList<String>();
    combos = new LinkedList<String>();

    if (this.length > 0) dfs(0, 0, 0, '+');
    return combos;
  }

  private void dfs(int start, long plus, long multiply, char operator) {
    // System.out.println("tokens: " + tokens.toString() + ", plus: " + plus + ", multiply: " + multiply);
    // can not start with 0
    boolean isValidNumber = num.charAt(start) != '0' || length - start == 1;
    if (isValidNumber) {
      long wholeNum = Long.parseLong(num.substring(start));
      if (calculateFinal(wholeNum, plus, multiply, operator) == target) {
        combos.add(String.join("", tokens) + num.substring(start));
      }
    }

    int endForEnd = num.charAt(start) == '0' ? Math.min(start+2, length) : length;
    for (int end=start+1; end < endForEnd; end++) {
      long curNum = Long.parseLong(num.substring(start, end));
      tokens.addLast(num.substring(start, end));

      long curMultiply = operator == '*' ? multiply * curNum : multiply;
      // *
      tokens.addLast("*");
      long multiplyForMultiply = (operator == '*' ? curMultiply : curNum) * (operator == '-' ? -1 : 1);
      dfs(end, plus, multiplyForMultiply, '*');
      tokens.removeLast();

      long curPlus = plus;
      if (operator == '+') curPlus += curNum;
      else if (operator == '-') curPlus -= curNum;
      // +
      tokens.addLast("+");
      dfs(end, curPlus + curMultiply, 0, '+');
      tokens.removeLast();
      // -
      tokens.addLast("-");
      dfs(end, curPlus + curMultiply, 0, '-');
      tokens.removeLast();

      tokens.removeLast();
    }
  }

  private long calculateFinal(long curNum, long plus, long multiply, char operator) {
    switch (operator) {
      case '*':
        return plus + multiply * curNum;
      case '+':
        return plus + multiply + curNum;
      case '-':
        return plus + multiply - curNum;
      default:
        throw new Error();
    }
  }
}
