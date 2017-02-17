class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False

        def reverseInt(i):
            j = 0
            while i > 0:
                i, tail = divmod(i, 10)
                j = j * 10 + tail
            return j

        return reverseInt(x) == x
