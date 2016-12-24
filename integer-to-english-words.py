class Solution(object):
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0:
            return 'Zero'

        appendixes = [
                '',
                'Thousand',
                'Million',
                'Billion',
                'Trillion'
                ]
        ones = [
                '',
                'One',
                'Two',
                'Three',
                'Four',
                'Five',
                'Six',
                'Seven',
                'Eight',
                'Nine'
                ]
        teens = [
                'Ten',
                'Eleven',
                'Twelve',
                'Thirteen',
                'Fourteen',
                'Fifteen',
                'Sixteen',
                'Seventeen',
                'Eighteen',
                'Nineteen'
                ]
        ties = [
                '',
                '',
                'Twenty',
                'Thirty',
                'Forty',
                'Fifty',
                'Sixty',
                'Seventy',
                'Eighty',
                'Ninety'
                ]
        groups = []
        while num:
            num, group = divmod(num, 1000)
            groups.append(group)

        def groupToString(group, i):
            if group == 0:
                return ''

            group, one = divmod(group, 10)
            group, ten = divmod(group, 10)
            group, hundred = divmod(group, 10)
            parts = []
            if hundred:
                parts.append(ones[hundred])
                parts.append('Hundred')

            if ten >= 2:
                parts.append(ties[ten])
                if one > 0:
                    parts.append(ones[one])
            elif ten == 1:
                parts.append(teens[one])
            elif one > 0:
                parts.append(ones[one])

            parts.append(appendixes[i])
            return ' '.join(filter(bool, parts))

        groupStrings = [groupToString(group, i) for i, group in enumerate(groups)]
        return ' '.join(reversed(list(filter(bool, groupStrings))))

# Solution().numberToWords(123)
