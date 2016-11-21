class Solution(object):
    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []

        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] < 0:
                res.append(index + 1)
            else:
                nums[index] = - nums[index]

        return res

# assert Solution().findDuplicates([2,2]) == [2]
