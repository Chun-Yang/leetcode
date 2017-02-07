class Solution(object):
    def lexicalOrder(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        values = []

        value = 1
        while True:
            if value <= n:
                values.append(value)
                if value * 10 <= n:
                    value *= 10
                    continue
            while value % 10 == 9:
                value //= 10
            if value == 0:
                break
            else:
                value += 1

        return values

# Solution().lexicalOrder(1000)
