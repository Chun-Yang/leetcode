class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        extra = True
        for i in reversed(range(len(digits))):
            if extra:
                extra, digits[i] = divmod(digits[i] + 1, 10)
            else:
                break
        return [1] + digits if extra else digits
