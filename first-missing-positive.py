class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = len(nums)
        for i in range(l):
            index = nums[i] - 1
            while True:
                if index < 0 or index >= l or nums[index] == index + 1:
                    break
                nextIndex = nums[index] - 1
                nums[index] = index + 1
                index = nextIndex

        for i in range(l):
            if nums[i] != i + 1:
                return i + 1

        return l + 1

# assert Solution().firstMissingPositive([3,4,-1,1]) == 2
# assert Solution().firstMissingPositive([2]) == 1
