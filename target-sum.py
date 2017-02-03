class Solution(object):
    def findTargetSumWays(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        size = len(nums)
        ways = {}

        def findWays(start, target):
            if (start, target) in ways:
                return ways[(start, target)]
            if start == size:
                return 1 if target == 0 else 0

            count = findWays(start + 1, target - nums[start]) + \
                    findWays(start + 1, target + nums[start])
            ways[(start, target)] = count
            return count

        return findWays(0, S)
