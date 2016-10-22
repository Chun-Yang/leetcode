class Solution(object):
    def integerReplacement(self, n):
        """
        :type n: int
        :rtype: int
        """
        steps = 0
        while n != 1:
            last = n & 1
            n >>= 1
            if last == 1:
                should_add = (n & 3) == 3 or (n & 7) == 5
                if should_add:
                    # +1, /2
                    n += 1

                steps += 2
            else:
                steps += 1

        return steps

# assert Solution().integerReplacement(8) == 3
# assert Solution().integerReplacement(7) == 4
# assert Solution().integerReplacement(3) == 2
# assert Solution().integerReplacement(100000000) == 31
