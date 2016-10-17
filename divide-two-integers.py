class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        if dividend == 0:
            return 0

        is_positive = (dividend >0 and divisor >0) or \
            (dividend <0 and divisor <0)

        divident_abs = abs(dividend)
        divisor_abs = abs(divisor)

        if divident_abs < divisor_abs:
            return 0

        # build up divisor_stack
        divisor_stack = [divisor_abs]
        quotient_stack = [1]
        while True:
            next_divisor = divisor_stack[-1] + divisor_stack[-1]
            if divident_abs > next_divisor:
                next_quotient = quotient_stack[-1] + quotient_stack[-1]
                quotient_stack.append(next_quotient)
                divisor_stack.append(next_divisor)
            else:
                break

        residue = divident_abs - divisor_stack[-1]
        quotient = quotient_stack[-1]

        # tear down divisor_stack
        # print("divisor_stack", divisor_stack)
        # print("residue", residue)
        # print("quotient", quotient)
        for i in range(len(divisor_stack) - 1, -1, -1 ):
            if residue < divisor_stack[i]:
                continue
            elif residue == divisor_stack[i]:
                quotient += quotient_stack[i]
                break
            elif residue > divisor_stack[i]:
                quotient += quotient_stack[i]
                residue -= divisor_stack[i]

        quotient = quotient if is_positive else -quotient

        # NOTE: make leetcode tests pass
        if quotient == 2147483648:
            return 2147483647

        return quotient

# assert Solution().divide(10, 2) == 5
# assert Solution().divide(17, 2) == 8
# assert Solution().divide(-11, 2) == -5
# assert Solution().divide(-2147483648, -1) == 2147483648
