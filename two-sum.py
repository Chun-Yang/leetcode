class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        indexes = {}
        for i, num in enumerate(nums):
            if (target - num) in indexes:
                return [i, indexes[target - num]]
            else:
                indexes[num] = i
