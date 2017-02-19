class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        length = 0

        for i in range(len(nums)):
            if nums[i] != val:
                length += 1
                nums[length - 1] = nums[i]

        return length

# assert Solution().removeElement([1,2,3,4,5], 3) == 4
# assert Solution().removeDuplicates([1,1,2,3,4,5]) == 5
# assert Solution().removeDuplicates([1,1,1,1]) == 1
# assert Solution().removeDuplicates([1,1,2,2]) == 2
