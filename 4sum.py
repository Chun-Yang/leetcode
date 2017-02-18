from collections import defaultdict

class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        quadruplets, pairs, size, nums = [], defaultdict(dict), len(nums), sorted(nums)

        for i in range(size):
            for j in range(i + 1, size):
                ni, nj = nums[i], nums[j]
                if nj < ni:
                    ni, nj = nj, ni

                if (ni, nj) in pairs[ni + nj]:
                    x, y = pairs[ni + nj][(ni, nj)]
                else:
                    x, y = - float('inf'), - float('inf')
                pairs[ni + nj][(ni, nj)] = (max(x, i), max(y, j))

        for i in range(size):
            if i > 0 and nums[i - 1] == nums[i]:
                continue
            for j in range(i + 1, size):
                if j > i + 1 and nums[j - 1] == nums[j]:
                    continue
                ni, nj = nums[i], nums[j]
                pairTarget = target - (ni + nj)
                for vx, vy in pairs[pairTarget]:
                    x, y = pairs[pairTarget][(vx, vy)]
                    if x > j and y > j:
                        quadruplets.append((ni, nj, vx, vy))

        return quadruplets

# Solution().fourSum([1,0,-1,0,-2,2], 0)
