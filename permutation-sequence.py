class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        nums = list(range(1, n + 1))
        res = []

        permutation = 1
        for i in range(1, n + 1):
            permutation *= i

        k = k - 1
        for i in range(n):
            permutation //= n - i
            num, k = divmod(k, permutation)
            res.append(nums.pop(num))

        return ''.join(str(num) for num in res)
