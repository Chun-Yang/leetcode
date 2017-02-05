class Solution(object):
    def totalHammingDistance(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        shift = 0
        distance = 0
        while True:
            if all(num >> shift == 0 for num in nums):
                return distance

            ones, zeros = 0, 0
            for num in nums:
                if (num >> shift) & 1 == 1:
                    ones += 1
                else:
                    zeros += 1

            distance += ones * zeros
            shift += 1
