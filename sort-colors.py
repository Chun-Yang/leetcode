class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        rwb = [0, 0, 0]
        for num in nums:
            rwb[num] += 1
        k = 0
        for i in range(len(rwb)):
            for j in range(rwb[i]):
                nums[k] = i
                k += 1
