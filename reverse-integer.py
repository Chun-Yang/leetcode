class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        maxNum = (1 << 31) - 1
        minNum = - (1 << 31)
        posiReversed = int(str(abs(x))[::-1])
        if x < 0 and (-posiReversed) >= minNum:
            return -posiReversed
        elif posiReversed <= maxNum:
            return posiReversed
        else:
            return 0

# assert Solution().reverse(1463847412) == 2147483641
