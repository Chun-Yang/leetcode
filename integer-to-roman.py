class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        numToRoman = {
                1: 'I',
                5: 'V',
                10: 'X',
                50: 'L',
                100: 'C',
                500: 'D',
                1000: 'M'
                }

        roman, index = '', 1

        while num > 0:
            num, residue = divmod(num, 10)
            if residue <= 3:
                roman = numToRoman[index] * residue + roman
            elif residue == 4:
                roman = numToRoman[index] + numToRoman[index * 5] + roman
            elif residue <= 8:
                roman = numToRoman[index * 5] + numToRoman[index] * (residue - 5) + roman
            else:
                roman = numToRoman[index] + numToRoman[index * 10] + roman
            index *= 10

        return roman
