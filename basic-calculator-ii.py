class Solution(object):
    def calculate(self, s):
        lowAns, lowSign, highAns, highSign, val = 0, '+', None, None, 0
        for c in s + '+':
            if c == ' ':
                continue
            elif c == '+' or c == '-':
                if highSign:
                    highAns = highAns * val if highSign == '*' else highAns // val
                    lowAns = lowAns + highAns if lowSign == '+' else lowAns - highAns
                else:
                    lowAns = lowAns + val if lowSign == '+' else lowAns - val
                lowSign, highAns, highSign, val = c, None, None, 0
            elif c == '*' or c == '/':
                if highSign:
                    highAns = highAns * val if highSign == '*' else highAns // val
                else:
                    highAns = val
                highSign, val = c, 0
            else:
                val = val * 10 + int(c)

        return lowAns
