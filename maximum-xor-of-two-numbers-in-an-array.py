class Solution(object):
    def findMaximumXOR(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_xor = 0
        mask = 0
        for i in reversed(range(32)):
            mask = mask | 1 << i
            prefixes = set(num & mask for num in nums)

            target = max_xor | 1 << i
            for prefix in prefixes:
                if prefix ^ target in prefixes:
                    max_xor = target
                    break

        return max_xor


assert Solution().findMaximumXOR([3, 10, 5, 25, 2, 8]) == 28
