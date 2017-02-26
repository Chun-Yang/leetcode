class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        def permute(nums):
            pre = nums[0] - 1
            perms = []
            for i, num in enumerate(nums):
                if num != pre:
                    for perm in permute(nums[:i] + nums[i + 1:]):
                        perms.append([num] + perm)
                pre = num
            return perms

        return permute(sorted(nums))

# assert Solution().permuteUnique([1,2]) == [[1,2], [2,1]]
# assert Solution().permuteUnique([1,1]) == [[1,1]]
# assert Solution().permuteUnique([1,1,2]) == [[1,1,2], [1,2,1], [2,1,1]]
