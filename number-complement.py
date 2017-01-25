class Solution(object):
    def findComplement(self, num):
        """
        :type num: int
        :rtype: int
        """
        length = 0
        copy = num
        while copy > 0:
            copy >>= 1
            length += 1
        return (2 ** length - 1) ^ num
