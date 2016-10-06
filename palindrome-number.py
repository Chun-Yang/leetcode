class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False

        if x == 0:
            return True

        x_str = str(x)
        reversed_str = x_str[::-1]
        for i in range(len(x_str)):
            if x_str[i] != reversed_str[i]:
                return False

        return True


# assert Solution().isPalindrome(12321)
# assert Solution().isPalindrome(11)
# assert not Solution().isPalindrome(10)
# assert not Solution().isPalindrome(10)
