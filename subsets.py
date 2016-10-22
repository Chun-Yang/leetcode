class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        nums_len = len(nums)
        sets_total = pow(2, nums_len)
        sets = [None] * sets_total
        for i in range(sets_total):
            new_set = []
            for j in range(nums_len):
                if (i >> j) & 1:
                    new_set.append(nums[j])

            sets[i] = new_set

        return sets

# result = Solution().subsets([1,2,3])
# print("result", result)
