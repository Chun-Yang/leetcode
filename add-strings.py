class Solution(object):
    def addStrings(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        digits = []
        carry = 0

        size1 = len(num1)
        size2 = len(num2)

        if size1 > size2:
            sizeMin, sizeMax, numsMax = size2, size1, num1
        else:
            sizeMin, sizeMax, numsMax = size1, size2, num2

        for i in range(sizeMin):
            val = int(num1[-i-1]) + int(num2[-i-1]) + carry
            carry, val = divmod(val, 10)
            digits.append(str(val))

        for i in range(sizeMin, sizeMax):
            val = int(numsMax[-i-1]) + carry
            carry, val = divmod(val, 10)
            digits.append(str(val))

        if carry:
            digits.append('1')

        digits.reverse()
        return ''.join(digits)

# Solution().addStrings('98', '9')
