class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums = sorted(nums)
        indexes = {}
        for i, num in enumerate(nums):
            indexes[num] = i

        size = len(nums)
        triplets = []

        # k > j > i
        # nk >= nj >= ni
        for i in range(size):
            if nums[i] > 0:
                break
            if i > 0 and nums[i - 1] == nums[i]:
                continue
            for j in range(i + 1, size):
                if j > i + 1 and nums[j - 1] == nums[j]:
                    continue
                ni, nj = nums[i], nums[j]
                nk = - ni - nj
                if (nk in indexes) and indexes[nk] > j:
                    triplets.append([ni, nj, nk])

        return triplets

# assert Solution().threeSum([0, 0, 0, 0]) == [[0, 0, 0]]
# assert Solution().threeSum([-1,0,1,2,-1,-4]) == [[-1,-1,2],[-1,0,1]]
