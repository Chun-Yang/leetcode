class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        size, step, start, end = len(nums), 1, 1, nums[0]

        if size == 1:
            return 0

        while end < size - 1:
            step += 1
            start, end = end + 1, max(i + nums[i] for i in range(start, end + 1))

        return step

# assert Solution().jump([0]) == 0
# assert Solution().jump([1,2,3]) == 2
# assert Solution().jump([1,1,1,1]) == 3
