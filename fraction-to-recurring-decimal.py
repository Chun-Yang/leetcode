class Solution(object):
    def fractionToDecimal(self, numerator, denominator):
        """
        :type numerator: int
        :type denominator: int
        :rtype: str
        """
        sign = '' if numerator * denominator >= 0 else '-'
        numerator, denominator = abs(numerator), abs(denominator)

        integer, residue = divmod(numerator, denominator)
        if residue == 0:
            return sign + str(integer)

        index, decimalHash, digits = 0, {}, []
        while residue != 0:
            digit, residue = divmod(residue * 10, denominator)

            if (digit, residue) in decimalHash:
                recurringAt = decimalHash[(digit, residue)]
                return sign + str(integer) + '.' + ''.join(digits[:recurringAt]) + '(' + ''.join(digits[recurringAt:]) + ')'

            digits.append(str(digit))
            decimalHash[(digit, residue)] = index
            index += 1

        return sign + str(integer) + '.' + ''.join(digits)


# assert Solution().fractionToDecimal(1, 3) == '0.(3)'
# assert Solution().fractionToDecimal(10, 100) == '0.1'
# assert Solution().fractionToDecimal(1, 6) == '0.1(6)'
# assert Solution().fractionToDecimal(-50, 8) == '-6.25'
