# from operator import add, sub, mul, floordiv

# class Solution(object):
#     def calculate(self, s):
#         lowAns, lowOp, highAns, highOp, val = 0, add, None, None, 0
#         cToOp = { '+': add, '-': sub, '*': mul, '/': floordiv }

#         for c in s + '+':
#             if c == ' ':
#                 continue
#             elif c == '+' or c == '-':
#                 if highOp:
#                     highAns = highOp(highAns, val)
#                     lowAns = lowOp(lowAns, highAns)
#                 else:
#                     lowAns = lowOp(lowAns, val)
#                 lowOp, highAns, highOp, val = cToOp[c], None, None, 0
#             elif c == '*' or c == '/':
#                 if highOp:
#                     highAns = highOp(highAns, val)
#                 else:
#                     highAns = val
#                 highOp, val = cToOp[c], 0
#             else:
#                 val = val * 10 + int(c)

#         return lowAns

from operator import add, sub, mul, floordiv

class Solution(object):
    def calculate(self, s):
        operands, operators = [], []
        i, size = 0, len(s)

        cToOp = { '+': add, '-': sub, '*': mul, '/': floordiv }

        def applyOp(op, right, left):
            return cToOp[op](left, right)

        def hasPrecedence(op1, op2):
            return op1 in ['*', '/'] and op2 in ['+', '-']

        while i < size:
            c = s[i]
            if c == ' ':
                i += 1
                continue
            elif c in ['+', '-', '*', '/']:
                i += 1
                while operators and not hasPrecedence(c, operators[-1]):
                    operands.append(applyOp(operators.pop(), operands.pop(), operands.pop()))
                operators.append(c)
            else:
                j = i
                while j < size and s[j] in '0123456789':
                    j += 1
                operands.append(int(s[i:j]))
                i = j

        while operators:
            operands.append(applyOp(operators.pop(), operands.pop(), operands.pop()))

        return operands[0]

# assert Solution().calculate('1 - 1 + 1') == 1
