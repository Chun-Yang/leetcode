class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        ones = [0] + [0] * num
        for i in range(1, num + 1):
            ones[i] = (i & 1) + ones[i >> 1]
        return ones
