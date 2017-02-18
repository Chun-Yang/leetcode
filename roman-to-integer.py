class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        romanToNum = {
                'I': 1,
                'V': 5,
                'X': 10,
                'L': 50,
                'C': 100,
                'D': 500,
                'M': 1000
                }

        value, size = 0, len(s)
        for i, c in enumerate(s):
            num = romanToNum[c]
            if i < size - 1 and romanToNum[s[i+1]] > num:
                value -= num
            else:
                value += num

        return value

