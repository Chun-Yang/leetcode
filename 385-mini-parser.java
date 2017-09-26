// Given a nested list of integers represented as a string, implement a parser to
// deserialize it.

// Each element is either an integer, or a list -- whose elements may also be
// integers or other lists.

// Note: You may assume that the string is well-formed:

// String is non-empty.
// String does not contain white spaces.
// String contains only digits 0-9, [, - ,, ].
// Example 1:

// Given s = "324",

// You should return a NestedInteger object which contains a single integer 324.
// Example 2:

// Given s = "[123,[456,[789]]]",

// Return a NestedInteger object containing a nested list with 2 elements:

// 1. An integer containing value 123.
// 2. A nested list containing two elements:
//     i.  An integer containing value 456.
//     ii. A nested list with one element:
//          a. An integer containing value 789.

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

import java.util.*;

class Solution {
  public NestedInteger deserialize(String s) {
    if (s.length() == 0) return null;

    int num = 0;
    int sign = 1;
    boolean isNumber = false;
    LinkedList<NestedInteger> nodes = new LinkedList<>();
    for (char c : s.toCharArray()) {
      switch (c) {
        case '[':
          NestedInteger node = new NestedInteger();
          if (!nodes.isEmpty()) nodes.getLast().add(node);
          nodes.add(node);
          isNumber = false;
          break;
        case ']':
          if (isNumber) {
            nodes.getLast().add(new NestedInteger(sign * num));
            num = 0;
            sign = 1;
            isNumber = false;
          }
          if (nodes.size() == 1) return nodes.getFirst();
          nodes.removeLast();
          break;
        case ',':
          if (isNumber) {
            nodes.getLast().add(new NestedInteger(sign * num));
            num = 0;
            sign = 1;
            isNumber = false;
          }
          break;
        case '-':
          sign = -1;
          isNumber = true;
          break;
        default:
          num = num * 10 + (c - '0');
          isNumber = true;
          break;
      }
    }
    return new NestedInteger(sign * num);
  }
}
