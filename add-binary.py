class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        la, lb = len(a), len(b)
        lmax = max(la, lb)
        res, extra = [], 0
        for i in range(lmax):
            numa = i < la and a[la - i - 1] == '1'
            numb = i < lb and b[lb - i - 1] == '1'
            num = numa + numb + extra
            extra = num >= 2
            res.append(num % 2)
        if extra:
            res.append(1)
        return ''.join(str(digit) for digit in reversed(res))
