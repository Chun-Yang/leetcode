class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        half, residue = divmod(sum(nums), 2)
        if residue or max(nums) > half:
            return False

        possible = [True] + [False] * half
        for num in nums:
            for j in reversed(range(num, half + 1)):
                possible[j] = possible[j] or possible[j - num]

        return possible[half]
