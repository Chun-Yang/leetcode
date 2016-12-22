class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        digits1 = list(int(i) for i in reversed(num1))
        digits2 = list(int(i) for i in reversed(num2))
        l1, l2 = len(digits1), len(digits2)
        digitsAns = []

        cache = [None] * 10
        def multiplySingle(digit):
            if cache[digit]:
                return cache[digit]

            extra, ans = 0, []
            for i in range(l1):
                extra, cur = divmod(digit * digits1[i] + extra, 10)
                ans.append(cur)
            if extra:
                ans.append(extra)

            cache[digit] = ans
            return cache[digit]

        def add(digitsX, digitsY):
            extra, ans = 0, []
            lx, ly = len(digitsX), len(digitsY)
            for i in range(max(lx, ly)):
                digitX = 0 if i >= lx else digitsX[i]
                digitY = 0 if i >= ly else digitsY[i]
                extra, cur = divmod(digitX + digitY + extra, 10)
                ans.append(cur)
            if extra:
                ans.append(extra)
            return ans

        for i2 in range(l2):
            digitsCur = [0] * i2 + multiplySingle(digits2[i2])
            digitsAns = add(digitsAns, digitsCur)

        while digitsAns and digitsAns[-1] == 0:
            digitsAns.pop()

        if not digitsAns:
            return '0'

        return ''.join(str(digit) for digit in reversed(digitsAns))

# assert Solution().multiply('10', '23') == '230'
# assert Solution().multiply('113', '345') == str(113 * 345)
