class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        visited = set()
        while True:
            if n in visited:
                return False
            if n == 1:
                return True

            visited.add(n)

            prev, n = n, 0
            while prev > 0:
                prev, digit = divmod(prev, 10)
                n += digit * digit

# Solution().isHappy(2)
