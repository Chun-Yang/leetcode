import re

class Solution(object):
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        return bool(re.compile('^1(00)*$').match('{0:b}'.format(num)))
