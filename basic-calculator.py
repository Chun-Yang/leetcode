class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        size = len(s)

        def calc(index):
            res = 0
            num = 0
            sign = 1

            while index < size:
                char = s[index]

                if char == ' ':
                    pass
                elif 0 <= (ord(char) - 48) <= 9:
                    digit = ord(char) - 48
                    num = num * 10 + digit
                elif char == '-' or char == '+':
                    res += sign * num
                    sign = 1 if char == '+' else -1
                    num = 0
                elif char == '(':
                    bracketRes, index = calc(index + 1)
                    res += sign * bracketRes
                    num = 0
                elif char == ')':
                    break

                index += 1

            return res + sign * num, index

        res, _ = calc(0)
        return res

# assert Solution().calculate('32 + (1 + 1)') == 34
