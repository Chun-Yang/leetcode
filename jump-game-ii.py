class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = len(nums)
        if l <= 1:
            return 0

        reach = 0
        steps = [None] * l
        steps[0] = 0
        for i in range(l):
            maxReach = i + nums[i]
            if maxReach >= l - 1:
                return steps[i] + 1
            if maxReach > reach:
                for j in range(reach + 1, maxReach + 1):
                    steps[j] = steps[i] + 1
                reach = maxReach

# assert(Solution().jump([0]) == 0)
# assert(Solution().jump([2,3,1,1,4]) == 2)
# assert(Solution().jump([1,2,1,1,1]) == 3)
