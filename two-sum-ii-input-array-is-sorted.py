class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        l = len(nums)
        i = 0
        j = l
        while True:
            j -= 1
            numj = nums[j]
            while nums[i] + numj < target:
                i += 1
            if nums[i] + numj == target:
                return (i+1, j+1)
