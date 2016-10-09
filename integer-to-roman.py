class Solution(object):
    DENOMINATORS = [1000, 100, 10, 1]
    ROMAIN_PAIRS = [['', 'M'], ['D', 'C'], ['L', 'X'], ['V', 'I']]

    def singleIntToRoman(self, index, num):
        pairs = Solution.ROMAIN_PAIRS
        if num <= 3:
            return pairs[index][1] * num
        elif num == 4:
            return pairs[index][1] + pairs[index][0]
        elif num <= 8:
            return pairs[index][0] + pairs[index][1] * (num - 5)
        elif num == 9:
            return pairs[index][1] + pairs[index - 1][1]
        else:
            print("num", num)
            raise 'num should not be larger than 9'

    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        # len is eight
        digits = [0] * 4
        residue = num
        for i, denominator in enumerate(Solution.DENOMINATORS):
            digits[i], residue = divmod(residue, denominator)

        solution = ''.join([self.singleIntToRoman(i, digit) for i, digit in enumerate(digits)])
        return solution

assert Solution().intToRoman(9) == 'IX'
