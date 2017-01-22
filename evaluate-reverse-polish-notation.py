class Solution(object):
    def evalRPN(self, tokens):
        values = []
        for token in tokens:
            if token in '+-*/':
                right = values.pop()
                left = values.pop()
                if token == '+':
                    values.append(left + right)
                elif token == '-':
                    values.append(left - right)
                elif token == '*':
                    values.append(left * right)
                elif token == '/':
                    values.append(1.0 * left / right)
            else:
                values.append(int(token))

        return values[0]

# Solution().evalRPN(["4","13","5","/","+"])
