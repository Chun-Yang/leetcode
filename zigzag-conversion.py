import math

class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        s_length = len(s)
        s_list = list(s)

        if s_length == 0:
            return ''

        if numRows <= 1:
            return s

        period = numRows * 2 - 2
        period_counts = math.ceil(float(s_length) / period)
        matrix = []

        for i in range(s_length, int(period * period_counts)):
            s_list.append(None)

        for i in range(int(period_counts)):
            matrix.append(s_list[i * period : i * period + numRows])
            matrix.append(\
                [None] \
                + list(reversed(s_list[i * period + numRows : (i + 1) * period])) \
                + [None]
            )

        list_zigzag = []
        for i in range(numRows):
            for column in matrix:
                if not (column[i] is None):
                    list_zigzag.append(column[i])

        s_zigzag = ''.join(list_zigzag)
        return s_zigzag

# assert Solution().convert("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR"
# assert Solution().convert("A", 2) == "A"
# assert Solution().convert("", 2) == ""
