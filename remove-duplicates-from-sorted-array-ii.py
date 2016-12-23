class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i = 2
        for cur in nums[2:]:
            if cur > nums[i - 2]:
                nums[i] = cur
                i += 1
        return min(len(nums), i)
