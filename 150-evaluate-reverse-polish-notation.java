// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//
//
// Valid operators are +, -, *, /.
// Each operand may be an integer or another expression.
//
//
//
// Some examples:
//
// ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
// ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6


// https://leetcode.com/problems/evaluate-reverse-polish-notation

// solution1: two stacks
// - one stack to save numbers
// - when we encouter an operator, we will pop 2 and push 1

import java.util.*;

class Solution {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<Integer>();
    for (String token : tokens) {
      if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
        int second = stack.pop();
        int first = stack.pop();
        switch (token) {
          case "+":
            stack.push(first + second);
            break;
          case "-":
            stack.push(first - second);
            break;
          case "*":
            stack.push(first * second);
            break;
          case "/":
            stack.push(first / second);
            break;
          default:
            throw new Error();
        }
      } else {
        stack.push(Integer.parseInt(token));
      }
    }
    return stack.pop();
  }
}
