// Implement a basic calculator to evaluate a simple expression string.
//
// The expression string may contain open ( and closing parentheses ),
// the plus + or minus sign -, non-negative integers and empty spaces  .
//
// You may assume that the given expression is always valid.
//
// Some examples:
//
// "1 + 1" = 2
// " 2-1 + 2 " = 3
// "(1+(4+5+2)-3)+(6+8)" = 23
//
//
//
//
// Note: Do not use the eval built-in library function.


// https://leetcode.com/problems/basic-calculator

// solution1: stack
// use a stack to track +/- signs before a bracket
// signMultiplier = 1 change when we have a sign, if we have a bracket, we times the current sign
// lastSign = '+' change when we have a sign
// when we encouter a (, we push lastSign in the stack
// toggle signMultiplier when we encouter a ) by poping stack
