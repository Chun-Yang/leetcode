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

  public List<String> addOperators(String num, int target) {
    if (num != null && num.length() == 0) return new LinkedList<String>();

    this.num = num;
    this.length = num.length();
    this.target = target;
    tokens = new LinkedList<String>();
    combos = new LinkedList<String>();

    dfs(0, 0, 0);

    return combos;
  }

  private void dfs(int start, long plus, long multiply) {
    if (start == length) {
      if (plus == target) combos.add(String.join("", tokens));
      return;
    }

    for (int end = start + 1; end <= length; end++) {
      // check if start is 0
      if (num.charAt(start) == '0' && end > start + 1) break;
      String token = num.substring(start, end);
      long curNum = Long.parseLong(token);
      tokens.addLast(token);
      // check if this is the first number
      if (start == 0) {
        dfs(end, curNum, 0);
      } else {
        // *
        tokens.addLast("*");
        dfs(end, plus - multiply + multiply * curNum, multiply * curNum);
        tokens.removeLast();
        // +
        tokens.addLast("+");
        dfs(end, plus + curNum, curNum);
        tokens.removeLast();
        // -
        tokens.addLast("-");
        dfs(end, plus - curNum, -curNum);
        tokens.removeLast();
      }

      tokens.removeLast();
    }
  }

  // String num;
  // int length;
  // int target;
  // Deque<String> tokens;
  // List<String> combos;

  // public List<String> addOperators(String num, int target) {
  //   this.num = num;
  //   this.length = num.length();
  //   this.target = target;
  //   tokens = new LinkedList<String>();
  //   combos = new LinkedList<String>();

  //   if (this.length > 0) dfs(0, 0, 0, '+');
  //   return combos;
  // }

  // private void dfs(int start, long plus, long multiply, char operator) {
  //   long wholeNum = Long.parseLong(num.substring(start));
  //   if (calculateFinal(wholeNum, plus, multiply, operator) == target) {
  //     combos.add(String.join("", tokens) + num.substring(start));
  //   }

  //   for (int end=start+1; end < length; end++) {
  //     long curNum = Long.parseLong(num.substring(start, end));
  //     tokens.addLast(num.substring(start, end));

  //     if (operator == '*') multiply *= curNum;
  //     // *
  //     tokens.addLast("*");
  //     long multiplyForMultiply = (operator == '*' ? multiply : curNum) * (operator == '-' ? -1 : 1);
  //     dfs(end, plus, multiplyForMultiply, '*');
  //     tokens.removeLast();

  //     if (operator == '+') plus += curNum;
  //     else if (operator == '-') plus -= curNum;
  //     // +
  //     tokens.addLast("+");
  //     dfs(end, plus + multiply, 0, '+');
  //     tokens.removeLast();
  //     // -
  //     tokens.addLast("-");
  //     dfs(end, plus + multiply, 0, '-');
  //     tokens.removeLast();

  //     tokens.removeLast();
  //   }
  // }

  // private long calculateFinal(long curNum, long plus, long multiply, char operator) {
  //   switch (operator) {
  //     case '*':
  //       return plus + multiply * curNum;
  //     case '+':
  //       return plus + multiply + curNum;
  //     case '-':
  //       return plus + multiply - curNum;
  //     default:
  //       throw new Error();
  //   }
  // }
}
